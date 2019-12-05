package net.ticket.loca.locabus.fragments.home_fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_outstation.view.*

import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.helpers.Helper
import net.ticket.loca.locabus.screens.CalendarActivity
import net.ticket.loca.locabus.screens.CitySearchActivity
import java.util.*


class OutstationFragment : Fragment() {

    var rootView: View? = null
    var to_id: Int? = null
    var from_id: Int? = null
    var j_date: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_outstation, container, false)
        // Inflate the layout for this fragment
        rootView?.let {
            setCurrentDate()
            it.to_city.setOnClickListener {
                val search = Intent(activity, CitySearchActivity::class.java)
                search.putExtra("Stop", it.to_city.getText().toString().trim())
                startActivityForResult(search, 103)
            }
            it.from_city.setOnClickListener {
                val search = Intent(activity, CitySearchActivity::class.java)
                search.putExtra("Stop", it.from_city.getText().toString().trim());
                startActivityForResult(search, 104)
            }

            it.today_lyaout.setOnClickListener {
                val calendar = Intent(activity, CalendarActivity::class.java)
                startActivityForResult(calendar, 101)
            }
        }
        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            101 -> {
                if (resultCode == Activity.RESULT_OK) {
                    rootView?.let {
                        it.tv_date.setText(data?.getStringExtra("Date"))
                        it.tv_month.setText(data?.getStringExtra("Month"))
                        it.tv_day.setText(data?.getStringExtra("Day"))
                    }
                    j_date = data?.getStringExtra("format_date")
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
                    rootView?.from_city?.setText(data!!.getStringExtra("Stop"))
                    from_id = data?.getIntExtra("Id", 0)
                }
            }
        }
    }

    fun setCurrentDate(){
        val c:Calendar  = Calendar.getInstance()
        rootView?.let {
            it.tv_month.setText(Helper.formatDateToString(c.time, "MMM yyyy"))
            it.tv_day.setText(Helper.formatDateToString(c.time, "EEEE"))
            it.tv_date.setText(Helper.formatDateToString(c.time, "dd"))
        }

        j_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")
    }
}
