package net.ticket.loca.locabus.fragments.home_fragments.inter_city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import net.ticket.loca.locabus.R


class SeatLayoutFragment : Fragment() {


    var rootView: View? = null
    var to_id: Int? = null
    var from_id: Int? = null
    var j_date: String? = null
    var bus_id: String? = null
    private var mlistener: OnSeatFragInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            to_id = it.getInt("to_id")
            from_id = it.getInt("from_id")
            j_date = it.getString("j_date")
            bus_id = it.getString("bus_id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_seat_layout, container, false)

        return rootView
    }



    override fun onDetach() {
        super.onDetach()
        mlistener = null
    }

    interface OnSeatFragInteractionListener {
        fun onSeatSubmitItemClick(bus_id: String?)
    }

    companion object {

        @JvmStatic
        fun newInstance(listn: OnSeatFragInteractionListener, to_id: Int?, from_id: Int?, j_date: String?,bus_id: String?) =
            SeatLayoutFragment().apply {
                arguments = Bundle().apply {
                    mlistener = listn
                    putString("bus_id", bus_id!!)
                    putInt("to_id", to_id!!)
                    putInt("from_id", from_id!!)
                    putString("j_date", j_date)
                }
            }
    }


}
