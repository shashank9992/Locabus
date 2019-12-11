package net.ticket.loca.locabus.interfaces;



import net.ticket.loca.locabus.models.SeatDataModels.SeatData;

import java.util.ArrayList;

/**
 * Created by chandrasekar on 14/02/16.
 */
public interface OnSeatSelected {

    void onSeatSelected(ArrayList<SeatData> seats);
}
