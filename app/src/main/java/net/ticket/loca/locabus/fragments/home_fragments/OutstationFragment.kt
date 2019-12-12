package net.ticket.loca.locabus.fragments.home_fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.error.AuthFailureError
import com.android.volley.request.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_outstation.view.*

import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.helpers.Helper
import net.ticket.loca.locabus.helpers.SessionManager
import net.ticket.loca.locabus.models.bus_model.BusData
import net.ticket.loca.locabus.models.bus_model.Buses
import net.ticket.loca.locabus.screens.BusResultActivity
import net.ticket.loca.locabus.screens.CalendarActivity
import net.ticket.loca.locabus.screens.CitySearchActivity
import net.ticket.loca.locabus.volley_pack.VolleyClass
import net.ticket.loca.locabus.volley_pack.VolleyObjectResponseListener
import org.json.JSONException
import org.json.JSONObject
import java.io.UnsupportedEncodingException
import java.util.*
import kotlin.collections.ArrayList


class OutstationFragment : Fragment() {

    var rootView: View? = null
    var to_id: Int? = null
    var from_id: Int? = null
    var j_date: String? = null
    var accessToken: String? = null
    var couch_selection: ArrayList<Int> = ArrayList()
    private var sessionManager: SessionManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_outstation, container, false)

        // Inflate the layout for this fragment
        rootView?.let {
            setDateOnResult(Helper.getTodaysDate())
            SetCouchSelection(1)
            it.layout_ac.setOnClickListener { SetCouchSelection(1) }
            it.layout_non_ac.setOnClickListener { SetCouchSelection(2) }
            it.layout_sleeper.setOnClickListener { SetCouchSelection(3) }
            it.layout_seater.setOnClickListener { SetCouchSelection(4) }
            it.to_city.setOnClickListener {
                val search = Intent(activity, CitySearchActivity::class.java)
                search.putExtra("Stop", it.to_city.getText().toString().trim())
                startActivityForResult(search, 104)
            }
            it.from_city.setOnClickListener {
                val search = Intent(activity, CitySearchActivity::class.java)
                search.putExtra("Stop", it.from_city.getText().toString().trim())
                startActivityForResult(search, 103)
            }

            it.today_lyaout.setOnClickListener {
                val calendar = Intent(activity, CalendarActivity::class.java)
                startActivityForResult(calendar, 101)
            }

            it.swipe_iv.setOnClickListener { view ->
                if (it.from_city.getText().toString().isNotEmpty() && it.to_city.getText().toString().isNotEmpty()) {
                    val from_name = it.from_city.getText().toString()
                    val to_name = it.to_city.getText().toString()
                    val from_did = from_id
                    val to_did = to_id
                    from_id = to_did
                    to_id = from_did
                    it.from_city.setText(to_name)
                    it.to_city.setText(from_name)
                }
            }
            it.today_tv.setOnClickListener {
                setDateOnResult(Helper.getTodaysDate())
            }
            it.tomorrow_tv.setOnClickListener {
                setDateOnResult(Helper.getTomorrowaDate())
            }

            it.inter_btn_search.setOnClickListener { view ->
                if (it.from_city.getText().toString().isEmpty() || it.to_city.getText().toString().isEmpty()) {
                    Toast.makeText(activity, "Please Select Cities.", Toast.LENGTH_SHORT).show()
                } else {
                    rootView?.progress_layout?.visibility = View.VISIBLE
                    sessionManager = SessionManager(activity)
                    accessToken = sessionManager?.mantisToken
                    if (accessToken.isNullOrEmpty()) {
                        _accessToken()
                    } else {
                        _GetBusList()
                    }

                }
            }
        }
        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            101 -> {
                if (resultCode == Activity.RESULT_OK) {
                    setDateOnResult(data?.getStringExtra("format_date"))
                }
            }
            103 -> {
                if (resultCode == Activity.RESULT_OK) {
                    rootView?.from_city?.setText(data!!.getStringExtra("Stop"))
                    to_id = data?.getIntExtra("Id", 0)

                }
            }
            104 -> {
                if (resultCode == Activity.RESULT_OK) {
                    rootView?.to_city?.setText(data!!.getStringExtra("Stop"))
                    from_id = data?.getIntExtra("Id", 0)
                }
            }
        }
    }

    private fun _GetBusList() {
        var url = ""
        url = (Helper.API_END_POINT + "/MantisSearch?fromCityId=" + from_id
                + "&toCityId=" + to_id + "&journeyDate=" + j_date)
        Log.d("url", url)
        VolleyClass(activity).volleyJsonObjectGetData(url, accessToken, null,
            object : VolleyObjectResponseListener {
                @Throws(JSONException::class)
                override fun onResponse(response: JSONObject) {
                    try {
                        //hide progress view
                        rootView?.progress_layout?.visibility = View.GONE
                        val bus_resul_list = ArrayList<Buses>()
                        val busData = Gson().fromJson<BusData>(response.getString("data"), BusData::class.java)

                        if (busData.getBuses() != null || busData.getBuses().size == 0) {
                            bus_resul_list.addAll(busData.getBuses())
                            val search_buses = Intent(activity, BusResultActivity::class.java)
                            search_buses.putExtra("from_id", from_id)
                            search_buses.putExtra("to_id", to_id)
                            search_buses.putExtra("from", rootView?.from_city?.getText().toString())
                            search_buses.putExtra("to", rootView?.to_city?.getText().toString())
                            search_buses.putExtra("journey_date", j_date)
                            search_buses.putExtra("bus_resul_list", bus_resul_list)
                            search_buses.putExtra("isVoice", false)
                            startActivity(search_buses)
                        } else {
                            SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Sorry...")
                                .setContentText("No buses Available on this root!")
                                .show()
                        }

                    } catch (e: Exception) {
                        Log.d("exception", e.message)
                        SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Oops...")
                            .setContentText("Something went wrong!")
                            .show()
                    }

                }

                override fun onError(message: String, title: String, status: Int) {
                    rootView?.progress_layout?.visibility = View.GONE
                    if (status == 401) {
                        _accessToken()
                    }
                }
            })
    }

    private fun _accessToken() {

        val uri = "http://api.iamgds.com/ota/Auth"

        try {
            val requestQueue = Volley.newRequestQueue(activity)
            val jsonBody = JSONObject()
            jsonBody.put("ClientId", 50)
            jsonBody.put("ClientSecret", "d66de12fa3473a93415b02494253f088")
            val mRequestBody = jsonBody.toString()

            val stringRequest = object : StringRequest(Request.Method.POST, uri,
                Response.Listener { response ->
                    if (response != null) {
                        sessionManager?.createMantisToken(response.replace("\"", ""))
                        rootView?.progress_layout?.visibility = View.VISIBLE
                        _GetBusList()
                    }
                }, Response.ErrorListener { error -> Log.e("LOG_VOLLEY", error.toString()) }) {
                override fun getBodyContentType(): String {
                    return "application/json; charset=utf-8"
                }

                @Throws(AuthFailureError::class)
                override fun getBody(): ByteArray? {
                    try {
                        return mRequestBody.toByteArray(charset("utf-8"))
                    } catch (uee: UnsupportedEncodingException) {
                        VolleyLog.wtf(
                            "Unsupported Encoding while trying to get the bytes of %s using %s",
                            mRequestBody,
                            "utf-8"
                        )
                        return null
                    }

                }

                //
            }

            requestQueue.add(stringRequest)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun SetCouchSelection(int: Int) {
        if (couch_selection.contains(int)) {
            couch_selection.remove(int)
        } else {
            couch_selection.add(int)
        }
        rootView?.let { view ->
            view.layout_ac.setBackgroundResource(R.drawable.border_black)
            view.layout_non_ac.setBackgroundResource(R.drawable.border_black)
            view.layout_sleeper.setBackgroundResource(R.drawable.border_black)
            view.layout_seater.setBackgroundResource(R.drawable.border_black)
            view.iv_ic_ac.setImageDrawable(resources.getDrawable(R.drawable.ic_ac_inactive))
            view.iv_ic_nonac.setImageDrawable(resources.getDrawable(R.drawable.ic_non_ac_inactive))
            view.iv_ic_sleeper.setImageDrawable(resources.getDrawable(R.drawable.ic_sleeper_inactive))
            view.iv_ic_seater.setImageDrawable(resources.getDrawable(R.drawable.ic_seater_inactive))

            if (couch_selection.contains(1)) {
                view.layout_ac.setBackgroundResource(R.drawable.border_blue)
                view.iv_ic_ac.setImageDrawable(resources.getDrawable(R.drawable.ic_ac_active))
            }
            if (couch_selection.contains(2)) {
                view.layout_non_ac.setBackgroundResource(R.drawable.border_blue)
                view.iv_ic_nonac.setImageDrawable(resources.getDrawable(R.drawable.ic_non_ac_active))
            }
            if (couch_selection.contains(3)) {
                view.layout_sleeper.setBackgroundResource(R.drawable.border_blue)
                view.iv_ic_sleeper.setImageDrawable(resources.getDrawable(R.drawable.ic_sleeper_active))
            }
            if (couch_selection.contains(4)) {
                view.layout_seater.setBackgroundResource(R.drawable.border_blue)
                view.iv_ic_seater.setImageDrawable(resources.getDrawable(R.drawable.ic_seater_active))
            }
        }
    }

    private fun setDateOnResult(date: String?) {
        rootView?.let { view ->
            view.today_tv.setBackgroundResource(R.drawable.border_black)
            view.today_tv.setTextColor(getResources().getColor(R.color.grey))
            view.tomorrow_tv.setBackgroundResource(R.drawable.border_black)
            view.tomorrow_tv.setTextColor(getResources().getColor(R.color.grey))

            if (date.equals(Helper.getTodaysDate())) {
                view.today_tv.setBackgroundResource(R.drawable.border_blue)
                view.today_tv.setTextColor(getResources().getColor(R.color.colorAccent))
            }else if (date.equals(Helper.getTomorrowaDate())) {
                view.tomorrow_tv.setBackgroundResource(R.drawable.border_blue)
                view.tomorrow_tv.setTextColor(getResources().getColor(R.color.colorAccent))
            }
            val c: Calendar = Calendar.getInstance()
            c.time = Helper.formatStringToDate(date,"yyyy-MM-dd")
            rootView?.let {
                it.tv_month.setText(Helper.formatDateToString(c.time, "MMM yyyy"))
                it.tv_day.setText(Helper.formatDateToString(c.time, "EEEE"))
                it.tv_date.setText(Helper.formatDateToString(c.time, "dd"))
            }
            j_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")

        }
    }
}
