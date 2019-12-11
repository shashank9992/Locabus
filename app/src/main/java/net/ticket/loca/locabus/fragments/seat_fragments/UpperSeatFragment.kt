package net.ticket.locabus.fragment_pack

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_upper_seat.view.*
import net.ticket.loca.locabus.R
import net.ticket.loca.locabus.adapters.BusSeatRecyclerAdapter
import net.ticket.loca.locabus.interfaces.OnSeatSelected
import net.ticket.loca.locabus.models.SeatDataModels.AbstractItem
import net.ticket.loca.locabus.models.SeatDataModels.SeatData
import net.ticket.loca.locabus.models.transactions.Passengers

import java.util.ArrayList

class UpperSeatFragment : Fragment(), OnSeatSelected {

    internal var abstractItem: AbstractItem? = null
    internal var iteminterface: UpperItemInteraction? = null

    private lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_upper_seat, container, false)

        abstractItem = arguments!!.getParcelable("data")
        abstractItem?.let {
            val uperItemsList = ArrayList<SeatData>()
            val manager = GridLayoutManager(activity, it.chartLayout.info.upper.maxCols)
            rootView.upper_recycler.setLayoutManager(manager)

            val adapter = BusSeatRecyclerAdapter(activity, uperItemsList,this)
            rootView.upper_recycler.setAdapter(adapter)
            val size = it.chartLayout.info.upper.maxRows * it.chartLayout.info.upper.maxCols

            for (i in 0 until size) {
                val seatdata = SeatData()
                val seatpositionarray = it.chartLayout.layout.upper
                for (j in seatpositionarray.indices) {
                    val seat = seatpositionarray[j]
                    val index = seat[1] * it.chartLayout.info.upper.maxCols + seat[2]
                    if (index == i) {
                        seatdata.setSeat_number(seat[0])
                        seatdata.setFieldEmpty(1)
                        seatdata.setSeat_width(3)
                        seatdata.setSeat_height(4)
                        seatdata.setType(seat[5])
                        seatdata.setSeat_name(it.chartSeats.seats[seat[0]])
                        seatdata.setSeat_status(it.seatsStatus.status[seat[0]])
                        val fares = it.seatsStatus.fares[seat[0]]
                        seatdata.setTotal_fare(fares[0])
                        seatdata.setBase_fare(fares[1])
                    }
                }
                uperItemsList.add(seatdata)
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
        iteminterface?.updateUpperItemList(passangerList)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is UpperItemInteraction) {
            iteminterface = context
        } else {
            throw RuntimeException(context.toString() + " must implement UpperItemInteraction")
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(parcel: AbstractItem) = UpperSeatFragment().apply {
            arguments = Bundle().apply {
                putParcelable("data", parcel)
            }
        }
    }

    interface UpperItemInteraction {
        fun updateUpperItemList(list: ArrayList<Passengers>)
    }

}
