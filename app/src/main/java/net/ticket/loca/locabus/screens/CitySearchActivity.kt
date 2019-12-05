package net.ticket.loca.locabus.screens

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.error.AuthFailureError
import com.android.volley.error.VolleyError
import com.android.volley.request.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_city_search.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.SearchStopAdapter
import net.ticket.loca.locabus.adapters.StopListAdapter
import net.ticket.loca.locabus.db_helper.RouteDatabase
import net.ticket.loca.locabus.helpers.Helper
import net.ticket.loca.locabus.helpers.SessionManager
import net.ticket.loca.locabus.models.StopListData
import net.ticket.loca.locabus.volley_pack.VolleyClass
import net.ticket.loca.locabus.volley_pack.VolleyObjectResponseListener
import org.json.JSONException
import org.json.JSONObject
import java.io.UnsupportedEncodingException
import java.util.ArrayList

class CitySearchActivity : AppCompatActivity() {

    private val recentList = ArrayList<StopListData>()
    private val popular_city_list = ArrayList<StopListData>()
    private val city_list = ArrayList<StopListData>()
    private var routeDatabase: RouteDatabase? = null
    private var stopListAdapter: StopListAdapter? = null
    private var selected_stop: String? = null
    private var access_token: String? = null
    private var searchStopAdapter: SearchStopAdapter? = null
    private var sessionManager: SessionManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_search)

        routeDatabase = RouteDatabase(this)
        sessionManager = SessionManager(this)

        access_token = sessionManager?.getMantisToken()
        access_token = access_token?.replace("\"", "")

//        if (SlangBuddy.isInitialized()){
//            SlangBuddy.getBuiltinUI().hide();
//        }


        iv_back.setOnClickListener { onBackPressed() }

        selected_stop = intent.getStringExtra("Stop")
        _GetCityList()


        edt_search.setOnItemClickListener { adapterView, view, i, l ->
            val pos = city_list.indexOf(searchStopAdapter?.getItem(i))

            val stops = Intent(this@CitySearchActivity, DashBoard::class.java)
            stops.putExtra("Stop", city_list[pos].getStop_name_english())
            stops.putExtra("Id", city_list[pos].getStop_id())
            setResult(Activity.RESULT_OK, stops)
            finish()
        }
    }

    private fun getRecentTrips() {

        val recent_cursor = routeDatabase!!.getURecentTrip()

        if (recent_cursor.getCount() > 0) {

            if (recent_cursor.moveToFirst()) {

                while (recent_cursor.moveToNext()) {

                    val stopListData = StopListData()

                    if (!selected_stop.equals(recent_cursor.getString(0), ignoreCase = true)) {
                        stopListData.setStop_name_english(recent_cursor.getString(0))
                        recentList.add(stopListData)
                    }

                }
            }
        }

        stopListAdapter = StopListAdapter(this@CitySearchActivity, recentList)
        recent_lv.setAdapter(stopListAdapter)

        recent_lv.setOnItemClickListener { adapterView, view, i, l ->
            val stops = Intent(this@CitySearchActivity, DashBoard::class.java)
            stops.putExtra("Stop", recentList[i].getStop_name_english())
            setResult(Activity.RESULT_OK, stops)
            finish()
        }
    }

    private fun getPopularTrips() {

        val recent_cursor = routeDatabase!!.getPopularStopName()

        if (recent_cursor.getCount() > 0) {

            while (recent_cursor.moveToNext()) {

                val stopListData = StopListData()
                stopListData.setStop_name_english(recent_cursor.getString(recent_cursor.getColumnIndex(RouteDatabase.STOP_NAME)))

                if (!selected_stop.equals(
                        recent_cursor.getString(recent_cursor.getColumnIndex(RouteDatabase.STOP_NAME)),
                        ignoreCase = true
                    )
                ) {
                    popular_city_list.add(stopListData)
                }

            }
        }

        stopListAdapter = StopListAdapter(this@CitySearchActivity, popular_city_list)
        popular_lv.setAdapter(stopListAdapter)

        popular_lv.setOnItemClickListener { adapterView, view, i, l ->
            val stops = Intent(this@CitySearchActivity, DashBoard::class.java)
            stops.putExtra("Stop", popular_city_list[i].getStop_name_english())
            setResult(Activity.RESULT_OK, stops)
            finish()
        }
    }

    private fun _GetCityList() {

        val uri = Helper.API_END_POINT + "/MantisGetCities"

        VolleyClass(this@CitySearchActivity).volleyJsonObjectGetData(
            uri,
            access_token,
            null,
            object : VolleyObjectResponseListener {
                @Throws(JSONException::class)
                override fun onResponse(response: JSONObject?) {

                    if (response != null) {

                        Log.d("res", response.toString())
                        val status = response.getBoolean("success")

                        if (status) {

                            val dataArray = response.getJSONArray("data")

                            for (i in 0 until dataArray.length()) {
                                val dataObj = dataArray.getJSONObject(i)
                                val stopListData = StopListData()
                                stopListData.setStop_name_english(dataObj.getString("City"))
                                stopListData.setStop_desc(dataObj.getString("State"))
                                stopListData.setStop_id(dataObj.getInt("CityId"))
                                city_list.add(stopListData)
                            }

                            searchStopAdapter = SearchStopAdapter(this@CitySearchActivity, city_list)
                            edt_search.setAdapter(searchStopAdapter)
                            edt_search.setThreshold(1)

                        }
                    }
                }

                override fun onError(message: String, title: String, status: Int) {

                    if (status == 401) {

                        _accessToken()
                    }

                }
            })
    }

    private fun _accessToken() {

        val uri = "http://api.iamgds.com/ota/Auth"

        try {
            val requestQueue = Volley.newRequestQueue(this)

            val jsonBody = JSONObject()
            jsonBody.put("ClientId", 50)
            jsonBody.put("ClientSecret", "d66de12fa3473a93415b02494253f088")
            val mRequestBody = jsonBody.toString()

            val stringRequest = object : StringRequest(Request.Method.POST, uri, object : Response.Listener<String> {
                override fun onResponse(response: String?) {
                    if (response != null) {

                        sessionManager?.let {
                            it.createMantisToken(response.replace("\"", ""))
                            _GetCityList()
                        }
                    }
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    Log.e("LOG_VOLLEY", error.toString())
                }
            }) {
                override fun getBodyContentType(): String {
                    return "application/json; charset=utf-8"
                }

                @Throws(AuthFailureError::class)
                override fun getBody(): ByteArray? {
                    try {
                        return mRequestBody?.toByteArray(charset("utf-8"))
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
}
