package net.ticket.loca.locabus.fragments.bottom_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.HomePagerAdapter
import net.ticket.loca.locabus.fragments.home_fragments.InterCityBusFragment
import net.ticket.loca.locabus.fragments.home_fragments.LocalStationFragment


class HomeFragment : Fragment() {

    var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val adapter = HomePagerAdapter(childFragmentManager)

        rootView?.let {
            it.viewPager.setAdapter(adapter)
            it.tabLayout.setupWithViewPager(it.viewPager)

        }
        return rootView
    }

}
