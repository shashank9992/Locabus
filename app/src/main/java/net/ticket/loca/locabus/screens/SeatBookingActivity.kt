package net.ticket.loca.locabus.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Response
import com.android.volley.error.AuthFailureError
import com.android.volley.request.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_seat_booking.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.SeatPagerAdapter
import net.ticket.loca.locabus.fragments.seat_fragments.EmptyViewFragment
import net.ticket.loca.locabus.helpers.Helper
import net.ticket.loca.locabus.helpers.SessionManager
import net.ticket.loca.locabus.models.SeatDataModels.AbstractItem
import net.ticket.loca.locabus.models.transactions.HoldRequest
import net.ticket.loca.locabus.models.transactions.Passengers
import net.ticket.locabus.fragment_pack.LowerSeatFragment
import net.ticket.locabus.fragment_pack.UpperSeatFragment
import org.json.JSONException
import java.util.HashMap

class SeatBookingActivity : AppCompatActivity(), LowerSeatFragment.LowerItemInteraction,
    UpperSeatFragment.UpperItemInteraction {

    private var lowerPassengerList = ArrayList<Passengers>()
    private var upperPassengerList = ArrayList<Passengers>()
    private var passengerList = ArrayList<Passengers>()
    private var pagerAdapter: SeatPagerAdapter? = null
    var mfare: Double = 0.0
    private var mantis_token = ""
    var abstractItem: AbstractItem? = null
    var holdingItem: HoldRequest? = null
    private var m_sessionManager: SessionManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_booking)

        m_sessionManager = SessionManager(this)
        val sessionManager = SessionManager(this)
        mantis_token = sessionManager.mantisToken

        holdingItem = intent.getParcelableExtra("data")
        abstractItem = intent.getParcelableExtra("abstractItem")

        //Creating our pager adapter
        pagerAdapter = SeatPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(pager)

        abstractItem?.let {
            //for lower
            if (it.chartLayout.info.lower != null) {
                pagerAdapter?.addFrag(LowerSeatFragment.newInstance(it), "Lower Deck")
            } else {
                pagerAdapter?.addFrag(EmptyViewFragment.newInstance(), "Lower Deck")
            }
            //for upper
            if (it.chartLayout.info.upper != null) {
                pagerAdapter?.addFrag(UpperSeatFragment.newInstance(it), "Upper Deck")
            } else {
                pagerAdapter?.addFrag(EmptyViewFragment.newInstance(), "Upper Deck")
            }
        }



        book_now.setOnClickListener {
            if (mfare != 0.0) {
                checkMarchantBalance(mfare)
            } else {
                Toast.makeText(this@SeatBookingActivity, "No Seat Selected", Toast.LENGTH_SHORT).show()
            }
        }
        booking_ticket_back_arrow.setOnClickListener { super@SeatBookingActivity.onBackPressed() }

    }


    private fun checkMarchantBalance(mfare: Double) {
        val sweetAlertDialog = SweetAlertDialog(this@SeatBookingActivity, SweetAlertDialog.PROGRESS_TYPE)
        sweetAlertDialog.show()
        sweetAlertDialog.titleText = "Booking Ticket"
        sweetAlertDialog.contentText = "Please wait"
        sweetAlertDialog.setCancelable(false)
        val url = Helper.API_END_POINT + "/MantisGetAgentBalance"
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.GET, url, null,
            Response.Listener { response ->
                if (response != null && response.getString("success") == "true") {
                    sweetAlertDialog.dismiss()
                    val balance = response.getJSONObject("data").getString("Balance").toDouble()
                    if (balance > mfare) {
                        holdingItem?.let {
                            it.passengers = passengerList
                            it.fare = mfare
                        }
                        val intent = Intent(this@SeatBookingActivity, SelectTravelPointActivity::class.java)
                        intent.putExtra("data", abstractItem)
                        intent.putExtra("holdingItem", holdingItem)
                        intent.putExtra("msrtc", intent.getStringExtra("msrtc"))
                        startActivity(intent)
                        this.finish()
                    } else {
                        Toast.makeText(this@SeatBookingActivity, "Low Balance.", Toast.LENGTH_SHORT).show()
                    }
                }
            }, Response.ErrorListener { error ->
                Toast.makeText(this@SeatBookingActivity, error.localizedMessage, Toast.LENGTH_SHORT).show()
                sweetAlertDialog.dismiss()
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
        val queue = Volley.newRequestQueue(this@SeatBookingActivity)
        queue.add(jsonObjectRequest)
    }


    override fun updateLowerItemList(list: ArrayList<Passengers>) {
        lowerPassengerList.clear()
        lowerPassengerList.addAll(list)
        updatePassangerList()
    }

    override fun updateUpperItemList(list: ArrayList<Passengers>) {
        upperPassengerList.clear()
        upperPassengerList.addAll(list)
        updatePassangerList()
    }

    private fun updatePassangerList() {
        mfare = 0.0
        passengerList.clear()
        passengerList.addAll(lowerPassengerList)
        passengerList.addAll(upperPassengerList)
        for (pass: Passengers in passengerList) {
            mfare += pass.fare
        }
        mfare.let {
            mfare = it
            txt_selected_seat_price.text = it.toString()
        }
    }

    fun _OpenSeatBooking() {
        val handler = Handler()
        handler.postDelayed({
            if (mfare != 0.0) {
                checkMarchantBalance(mfare)
            } else {
                Toast.makeText(this@SeatBookingActivity, "No Seat Selected", Toast.LENGTH_SHORT).show()
            }
        }, 1500)

    }

}
