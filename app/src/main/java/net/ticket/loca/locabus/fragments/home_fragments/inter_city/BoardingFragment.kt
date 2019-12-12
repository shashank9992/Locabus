package net.ticket.loca.locabus.fragments.home_fragments.inter_city

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import net.ticket.loca.locabus.R

class BoardingFragment : Fragment() {


    private var param2: String? = null
    private var listener: OnBoardingFragmentInteractionListener? = null
    var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param2 = it.getString("")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_boarding, container, false)

        return rootView
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onBoardingpointSelect(uri)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnBoardingFragmentInteractionListener {
        fun onBoardingpointSelect(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: OnBoardingFragmentInteractionListener) =
            BoardingFragment().apply {
                arguments = Bundle().apply {
                    listener = param1

                }
            }
    }
}
