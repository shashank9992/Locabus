package net.ticket.loca.locabus.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.error.AuthFailureError
import com.android.volley.error.VolleyError
import com.android.volley.request.JsonObjectRequest
import com.android.volley.request.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_bus_result.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.OutStationBusAdapter
import net.ticket.loca.locabus.helpers.Helper
import net.ticket.loca.locabus.helpers.SessionManager
import net.ticket.loca.locabus.models.SeatDataModels.AbstractItem
import net.ticket.loca.locabus.models.bus_model.BusData
import net.ticket.loca.locabus.models.bus_model.Buses
import net.ticket.loca.locabus.models.transactions.HoldRequest
import net.ticket.loca.locabus.volley_pack.VolleyClass
import net.ticket.loca.locabus.volley_pack.VolleyObjectResponseListener
import net.ticket.loca.locabus.widgets.RecyclerTouchListener
import net.ticket.locabus.fragment_pack.LowerSeatFragment
import net.ticket.locabus.fragment_pack.UpperSeatFragment
import org.json.JSONException
import org.json.JSONObject
import java.io.UnsupportedEncodingException
import java.util.ArrayList
import java.util.HashMap

class BusResultActivity : AppCompatActivity() {

    private var sessionManager: SessionManager? = null
    private val holdingItem = HoldRequest()
    private var mantis_token = ""
    private var bus_resul_list = ArrayList<Buses>()
    var abstractItem: AbstractItem? = null
    private var interCityBusAdapter: OutStationBusAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_result)
        sessionManager = SessionManager(this@BusResultActivity)
        mantis_token = sessionManager!!.getMantisToken()

        val data = intent

        holdingItem.fromCityId = data.getIntExtra("from_id", 0)
        holdingItem.toCityId = data.getIntExtra("to_id", 0)
        holdingItem.journeyDate =  data.getStringExtra("journey_date")
        holdingItem.fromCityName = data.getStringExtra("from")
        holdingItem.toCityName = data.getStringExtra("to")
        bus_resul_list = data.getParcelableArrayListExtra("bus_resul_list")
        tv_source.setText(holdingItem.fromCityName)
        tv_dest.setText(holdingItem.toCityName)

        interCityBusAdapter = OutStationBusAdapter(this@BusResultActivity, bus_resul_list)
        bus_list.setHasFixedSize(true)
        bus_list.layoutManager = LinearLayoutManager(this@BusResultActivity)
        bus_list.setAdapter(interCityBusAdapter)

        iv_back.setOnClickListener {
            onBackPressed()
        }
        bus_list.addOnItemTouchListener(RecyclerTouchListener(
            this@BusResultActivity, bus_list
        ) { view, position ->
            holdingItem.busId = bus_resul_list[position].routeBusId
            holdingItem.busName = bus_resul_list[position].companyName
            holdingItem.busType = bus_resul_list[position].displayBusType

            getSeatInfoData(
                Helper.API_END_POINT + "/MantisGetChart?fromCityId=" + holdingItem.fromCityId +
                        "&toCityId=" + holdingItem.toCityId + "&journeyDate=" + holdingItem.journeyDate + "&busId=" + holdingItem.busId
            )

        })
    }

    private fun getSeatInfoData(url: String) {
        progress_layout.visibility = View.VISIBLE
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.GET, url, null,
            Response.Listener { response ->
                progress_layout.visibility = View.GONE
                try {
                    if (response != null && response.getBoolean("success")) {
                        abstractItem =
                                Gson().fromJson<AbstractItem>(response.getString("data"), AbstractItem::class.java)

                        if (abstractItem != null) {
                            val seat_layout = Intent(this@BusResultActivity, SeatBookingActivity::class.java)
                            seat_layout.putExtra("data", holdingItem)
                            seat_layout.putExtra("abstractItem", abstractItem)
                            startActivity(seat_layout)
                        } else {
                            SweetAlertDialog(this@BusResultActivity, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Sorry...")
                                .setContentText("No data Available")
                                .show()
                        }
                    } else {
                        SweetAlertDialog(this@BusResultActivity, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Error...")
                            .setContentText(  response!!.getJSONObject("Error").getString("Msg"))
                            .show()
                    }
                } catch (e: JSONException) {
                    SweetAlertDialog(this@BusResultActivity, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Error...")
                        .setContentText(e.message)
                        .show()
                    e.printStackTrace()
                }
            }, Response.ErrorListener {

                progress_layout.visibility = View.GONE
            }) {

            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val header = HashMap<String, String>()
                header["access-token"] = mantis_token
                return header
            }
        }

        jsonObjectRequest.retryPolicy = DefaultRetryPolicy(
            0,
            1,
            1f
        )
        val queue = Volley.newRequestQueue(this@BusResultActivity)
        queue.add(jsonObjectRequest)
    }

}
