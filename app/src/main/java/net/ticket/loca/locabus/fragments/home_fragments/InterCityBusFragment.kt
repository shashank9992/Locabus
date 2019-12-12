package net.ticket.loca.locabus.fragments.home_fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_inter_city_bus.view.*

import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.fragments.home_fragments.inter_city.BoardingFragment
import net.ticket.loca.locabus.fragments.home_fragments.inter_city.BusListFragment
import net.ticket.loca.locabus.fragments.home_fragments.inter_city.SeatLayoutFragment
import net.ticket.loca.locabus.helpers.Helper
import net.ticket.loca.locabus.screens.CalendarActivity
import net.ticket.loca.locabus.screens.CitySearchActivity
import java.util.*


class InterCityBusFragment : Fragment(), BusListFragment.OnBusFragInteractionListener,
    SeatLayoutFragment.OnSeatFragInteractionListener, BoardingFragment.OnBoardingFragmentInteractionListener {


    var rootView: View? = null
    var to_id: Int? = null
    var from_id: Int? = null
    var j_date: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_inter_city_bus, container, false)


        rootView?.let {
            it.tabLayout.setTabWidthAsWrapContent(0)
            it.tabLayout.setTabWidthAsWrapContent(1)
            setDateOnResult(Helper.getTodaysDate())
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

            it.date_layout.setOnClickListener {
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
                    setDateOnResult(data?.getStringExtra("format_date"))
                    showBusResults()
                }
            }
            103 -> {
                if (resultCode == Activity.RESULT_OK) {
                    rootView?.from_city?.setText(data!!.getStringExtra("Stop"))
                    to_id = data?.getIntExtra("Id", 0)
                    showBusResults()
                }
            }
            104 -> {
                if (resultCode == Activity.RESULT_OK) {
                    rootView?.to_city?.setText(data!!.getStringExtra("Stop"))
                    from_id = data?.getIntExtra("Id", 0)
                    showBusResults()
                }
            }
        }
    }

    private fun showBusResults() {
        if (to_id != null && from_id != null) {
            val count = childFragmentManager.getBackStackEntryCount()
            for (i in 0 until count) {
                childFragmentManager.popBackStack()
            }
            val  transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.contentContainer, BusListFragment.newInstance(this, to_id, from_id, j_date))
            transaction.addToBackStack("fragment")
            transaction.commit()
        }
    }

    private fun TabLayout.setTabWidthAsWrapContent(tabPosition: Int) {
        val layout = (this.getChildAt(0) as LinearLayout).getChildAt(tabPosition) as LinearLayout
        val layoutParams = layout.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 0f
        layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        layout.layoutParams = layoutParams
    }


    private fun setDateOnResult(date: String?) {
        rootView?.let { view ->
            val c: Calendar = Calendar.getInstance()
            c.time = Helper.formatStringToDate(date, "yyyy-MM-dd")
            rootView?.let {
                it.tv_month.setText(Helper.formatDateToString(c.time, "MMM yyyy"))
                it.tv_day.setText(Helper.formatDateToString(c.time, "EEEE"))
                it.tv_date.setText(Helper.formatDateToString(c.time, "dd"))
            }
            j_date = Helper.formatDateToString(c.time, "yyyy-MM-dd")
        }
    }

    override fun onBusItemClick(bus_id: String?) {
        val  transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.contentContainer, SeatLayoutFragment.newInstance(this, to_id, from_id, j_date,bus_id))
        transaction.addToBackStack("fragment")
        transaction.commit()

    }

    override fun onSeatSubmitItemClick(bus_id: String?) {
        val  transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.contentContainer, BoardingFragment.newInstance(this))
        transaction.addToBackStack("fragment")
        transaction.commit()
    }

    override fun onBoardingpointSelect(uri: Uri) {

    }

}
