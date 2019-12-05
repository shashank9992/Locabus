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

    var Date: String? = null
    var Month: String? = null
    var Day: String? = null
    var format_date: String? = null
    var first_format_date: String? = null
    var second_format_date: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val c: Calendar = Calendar.getInstance()

        Month = Helper.formatDateToString(c.time, "MMM yyyy")
        Day = Helper.formatDateToString(c.time, "EEEE")
        Date = Helper.formatDateToString(c.time, "dd")
        format_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")
        first_format_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")

        //setting first date view
        first_month_tv.setText(Month)
        first_day_tv.setText(Day)
        first_date_tv.setText(Date)

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
            act.putExtra("Date", Date)
            act.putExtra("Month", Month)
            act.putExtra("Day", Day)
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
            Month = Helper.formatDateToString(calander.time, "MMM yyyy")
            Day = Helper.formatDateToString(calander.time, "EEEE")
            Date = Helper.formatDateToString(calander.time, "dd")
            format_date = Helper.formatDateToString(calander.time, "yyyy-MM-dd")

            onLayoutDateLayoutSelect(false, false)
        }

    }

    fun onLayoutDateLayoutSelect(first: Boolean, second: Boolean) {
        //setting colors
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
            Month = first_month_tv.text.toString()
            Day = first_day_tv.text.toString()
            Date = first_date_tv.text.toString()
            format_date = first_format_date
            //setting colors
            today_lyaout.setBackgroundResource(R.drawable.rounded_blue)
            first_month_tv.setTextColor(resources.getColor(R.color.white))
            first_day_tv.setTextColor(resources.getColor(R.color.white))
            first_date_tv.setTextColor(resources.getColor(R.color.white))

        } else if (second) {
            Month = second_month_tv.text.toString()
            Day = second_day_tv.text.toString()
            Date = second_date_tv.text.toString()
            format_date = second_format_date
            //setting colors
            tomorrow_lyaout.setBackgroundResource(R.drawable.rounded_blue)
            second_month_tv.setTextColor(resources.getColor(R.color.white))
            second_day_tv.setTextColor(resources.getColor(R.color.white))
            second_date_tv.setTextColor(resources.getColor(R.color.white))
        }

    }
}
