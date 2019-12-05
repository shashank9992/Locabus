package net.ticket.loca.locabus.fragments.bottom_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.view.*

import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.IntroPagerAdapter
import net.ticket.loca.locabus.adapters.TabAdapter
import net.ticket.loca.locabus.fragments.home_fragments.LocalStationFragment
import net.ticket.loca.locabus.fragments.home_fragments.OutstationFragment


class HomeFragment : Fragment() {

    var rootView: View? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val adapter = TabAdapter(childFragmentManager)
        adapter.addFragment(OutstationFragment(),"OutStation Services")
        adapter.addFragment(LocalStationFragment(),"Local Bus Service")

        rootView?.let {
            it.viewPager.setAdapter(adapter)
            it.tabLayout.setupWithViewPager(it.viewPager)
        }
        return rootView
    }

}