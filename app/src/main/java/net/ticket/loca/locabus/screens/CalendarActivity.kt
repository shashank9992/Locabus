package net.ticket.loca.locabus.screens

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calendar.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.helpers.Helper
import java.util.*
import java.text.SimpleDateFormat


class CalendarActivity : AppCompatActivity() {

    var format_date: String? = null
    var first_format_date: String? = null
    var second_format_date: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val c: Calendar = Calendar.getInstance()

        format_date = Helper.formatDateToString(c.time, "dd-MM-yyyy")
        first_format_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")

        //setting first date view
        first_month_tv.setText(Helper.formatDateToString(c.time, "MMM yyyy"))
        first_day_tv.setText(Helper.formatDateToString(c.time, "EEEE"))
        first_date_tv.setText(Helper.formatDateToString(c.time, "dd"))

        c.add(Calendar.DATE, 1);
//setting second date view
        second_month_tv.setText(Helper.formatDateToString(c.time, "MMM yyyy"))
        second_day_tv.setText(Helper.formatDateToString(c.time, "EEEE"))
        second_date_tv.setText(Helper.formatDateToString(c.time, "dd"))
        second_format_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")

        today_lyaout.setOnClickListener {
            onLayoutDateLayoutSelect(true, false)
        }
        tomorrow_lyaout.setOnClickListener {
            onLayoutDateLayoutSelect(false, true)
        }
        send_date_btn.setOnClickListener {
            val act = Intent(this@CalendarActivity, DashBoard::class.java)
            act.putExtra("format_date", format_date)
            setResult(Activity.RESULT_OK, act)
            finish()
        }
        iv_back.setOnClickListener { onBackPressed() }

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calander = Calendar.getInstance()

            calander.set(Calendar.YEAR, year)
            calander.set(Calendar.MONTH, month)
            calander.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            format_date = Helper.formatDateToString(calander.time, "yyyy-MM-dd")

            onLayoutDateLayoutSelect(false, false)
        }

    }

    fun onLayoutDateLayoutSelect(first: Boolean, second: Boolean) {
        //setting colors
        val calendar = GregorianCalendar()
        today_lyaout.setBackgroundResource(R.drawable.border_black)
        first_month_tv.setTextColor(resources.getColor(R.color.grey))
        first_day_tv.setTextColor(resources.getColor(R.color.grey))
        first_date_tv.setTextColor(resources.getColor(R.color.grey))
        //setting colors
        tomorrow_lyaout.setBackgroundResource(R.drawable.border_black)
        second_month_tv.setTextColor(resources.getColor(R.color.grey))
        second_day_tv.setTextColor(resources.getColor(R.color.grey))
        second_date_tv.setTextColor(resources.getColor(R.color.grey))
        if (first) {
            format_date = first_format_date
            calendarView.date = calendar.time.time
            //setting colors
            today_lyaout.setBackgroundResource(R.drawable.rounded_blue)
            first_month_tv.setTextColor(resources.getColor(R.color.white))
            first_day_tv.setTextColor(resources.getColor(R.color.white))
            first_date_tv.setTextColor(resources.getColor(R.color.white))

        } else if (second) {
            format_date = second_format_date
            calendar.add(Calendar.DATE,1)
            calendarView.date = calendar.time.time
            //setting colors
            tomorrow_lyaout.setBackgroundResource(R.drawable.rounded_blue)
            second_month_tv.setTextColor(resources.getColor(R.color.white))
            second_day_tv.setTextColor(resources.getColor(R.color.white))
            second_date_tv.setTextColor(resources.getColor(R.color.white))
        }

    }
}
