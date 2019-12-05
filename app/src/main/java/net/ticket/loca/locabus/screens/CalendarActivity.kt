package net.ticket.loca.locabus.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calendar.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.helpers.Helper
import java.util.*
import android.widget.Toast




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
        Day = Helper.formatDateToString(c.time, "EEE")
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
        second_day_tv.setText(Helper.formatDateToString(c.time, "EEE"))
        second_date_tv.setText(Helper.formatDateToString(c.time, "dd"))
        second_format_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")

        today_lyaout.setOnClickListener {
            onLayoutDateLayoutSelect(true, false)
        }
        tomorrow_lyaout.setOnClickListener {
            onLayoutDateLayoutSelect(false, true)
        }

        calendarView.setOnDateChangeListener({ view, year, month, dayOfMonth ->
            val dt:Date =  Date(calendarView.getDate())
            Month = Helper.formatDateToString(dt, "MMM yyyy")
            Day = Helper.formatDateToString(dt, "EEE")
            Date = Helper.formatDateToString(dt, "dd")
            format_date = Helper.formatDateToString(dt, "yyyy-MM-dd")

            onLayoutDateLayoutSelect(false, false)
        })

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

        } else if(second){
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
