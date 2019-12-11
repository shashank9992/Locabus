package net.ticket.locabus.fragment_pack

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_lower_seat.view.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.BusSeatRecyclerAdapter
import net.ticket.loca.locabus.interfaces.OnSeatSelected
import net.ticket.loca.locabus.models.SeatDataModels.AbstractItem
import net.ticket.loca.locabus.models.SeatDataModels.SeatData
import net.ticket.loca.locabus.models.transactions.Passengers


import java.util.ArrayList

class LowerSeatFragment : Fragment(), OnSeatSelected {


    internal var abstractItem: AbstractItem? = null
    internal var iteminterface: LowerItemInteraction? = null

    private lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_lower_seat, container, false)

        abstractItem = arguments!!.getParcelable("data")
        abstractItem?.let {
            val lowerItemsList = ArrayList<SeatData>()
            val manager = GridLayoutManager(activity, it.getChartLayout().info.lower.maxCols)
            rootView.lower_recycler.setLayoutManager(manager)

            val adapter = BusSeatRecyclerAdapter(activity, lowerItemsList,this)
            rootView.lower_recycler.setAdapter(adapter)

            val lowersize = it.getChartLayout().info.lower.maxRows * it.getChartLayout().info.lower.maxCols
            for (i in 0 until lowersize) {
                val seatdata = SeatData()
                val seatpositionarray = it.getChartLayout().layout.lower
                for (j in seatpositionarray.indices) {
                    val seat = seatpositionarray[j]
                    val index = seat[1] * it.getChartLayout().info.lower.maxCols + seat[2]
                    if (index == i) {
                        seatdata.setSeat_number(seat[0])
                        seatdata.setFieldEmpty(1)
                        seatdata.setSeat_width(3)
                        seatdata.setSeat_height(4)
                        seatdata.setType(seat[5])
                        seatdata.setSeat_name(it.getChartSeats().seats[seat[0]])
                        seatdata.setSeat_status(it.getSeatsStatus().status[seat[0]])
                        val fares = it.getSeatsStatus().fares[seat[0]]
                        seatdata.setTotal_fare(fares[0])
                        seatdata.setBase_fare(fares[1])
                    }
                }
                lowerItemsList.add(seatdata)
                adapter.notifyDataSetChanged()
            }
        }
        return rootView
    }

    override fun onSeatSelected(seats: ArrayList<SeatData>) {
        val passangerList = ArrayList<Passengers>()
        for (seat : SeatData in seats){
            val passanger = Passengers()
            passanger.seatNo = seat.seat_name
            passanger.fare = seat.base_fare
            passanger.isAcSeat = false
            passanger.seatTypeId = seat.type
            passanger.name = ""
            passanger.gender = ""
            passanger.age = 0
            passangerList.add(passanger)
        }
        iteminterface?.updateLowerItemList(passangerList)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LowerItemInteraction) {
            iteminterface = context
        } else {
            throw RuntimeException(context.toString() + " must implement LowerItemInteraction")
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(parcel: AbstractItem) = LowerSeatFragment().apply {
            arguments = Bundle().apply {
                putParcelable("data", parcel)
            }
        }
    }

    interface LowerItemInteraction {
        fun updateLowerItemList(list: ArrayList<Passengers>)
    }

}
