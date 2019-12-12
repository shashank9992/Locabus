package net.ticket.loca.locabus.fragments.home_fragments.inter_city

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.error.AuthFailureError
import com.android.volley.request.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_bus_list.view.*

import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.OutStationBusAdapter
import net.ticket.loca.locabus.helpers.Helper
import net.ticket.loca.locabus.helpers.SessionManager
import net.ticket.loca.locabus.models.bus_model.BusData
import net.ticket.loca.locabus.models.bus_model.Buses
import net.ticket.loca.locabus.volley_pack.VolleyClass
import net.ticket.loca.locabus.volley_pack.VolleyObjectResponseListener
import org.json.JSONException
import org.json.JSONObject
import java.io.UnsupportedEncodingException

class BusListFragment : Fragment() {

    var rootView: View? = null
    var to_id: Int? = null
    var from_id: Int? = null
    var j_date: String? = null
    private var mlistener: OnBusFragInteractionListener? = null
    var accessToken: String? = null
    val bus_resul_list = ArrayList<Buses>()
    private var sessionManager: SessionManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            to_id = it.getInt("to_id")
            from_id = it.getInt("from_id")
            j_date = it.getString("j_date")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bus_list, container, false)
        if (to_id == null || from_id == null) {
            Toast.makeText(activity, "Please Select Cities.", Toast.LENGTH_SHORT).show()
        } else {
            rootView?.progress_layout?.visibility = View.VISIBLE
            rootView?.frameLayout2?.visibility = View.GONE
            sessionManager = SessionManager(activity)
            accessToken = sessionManager?.mantisToken
            if (accessToken.isNullOrEmpty()) {
                _accessToken()
            } else {
                _GetBusList()
            }

            rootView?.show_more?.setOnClickListener {
                if(bus_resul_list.size != 0){
                    rootView?.show_more?.visibility = View.GONE
                    rootView?.bus_list?.visibility = View.VISIBLE
                }else{
                    Toast.makeText(activity, "No Bus Found.", Toast.LENGTH_SHORT).show()
                    rootView?.show_more?.visibility = View.VISIBLE
                    rootView?.bus_list?.visibility = View.GONE
                }

            }

        }

        return rootView
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
                        rootView?.frameLayout2?.visibility = View.VISIBLE

                        val busData = Gson().fromJson<BusData>(response.getString("data"), BusData::class.java)

                        if (busData.getBuses() != null || busData.getBuses().size == 0) {
                            bus_resul_list.addAll(busData.getBuses())
                            val interCityBusAdapter = OutStationBusAdapter(activity, bus_resul_list)
                            rootView?.bus_list?.setHasFixedSize(true)
                            rootView?.bus_list?.layoutManager = LinearLayoutManager(activity)
                            rootView?.bus_list?.setAdapter(interCityBusAdapter)

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
                    rootView?.frameLayout2?.visibility = View.VISIBLE
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
            }

            requestQueue.add(stringRequest)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }



    override fun onDetach() {
        super.onDetach()
        mlistener = null
    }


    interface OnBusFragInteractionListener {
        fun onBusItemClick(bus_id: String?)
    }

    companion object {

        @JvmStatic
        fun newInstance(listn: OnBusFragInteractionListener, to_id: Int?, from_id: Int?, j_date: String?) =
            BusListFragment().apply {
                arguments = Bundle().apply {
                    mlistener = listn
                    putInt("to_id", to_id!!)
                    putInt("from_id", from_id!!)
                    putString("j_date", j_date)
                }
            }
    }


}
