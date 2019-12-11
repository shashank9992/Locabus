package net.ticket.loca.locabus.fragments.seat_fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import net.ticket.loca.locabus.R

class EmptyViewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empty_view, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            EmptyViewFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
