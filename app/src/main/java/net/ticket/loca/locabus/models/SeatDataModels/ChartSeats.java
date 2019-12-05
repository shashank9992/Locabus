package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ChartSeats implements Parcelable {

    private ArrayList<String> Seats;

    protected ChartSeats(Parcel in) {
        Seats = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(Seats);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChartSeats> CREATOR = new Creator<ChartSeats>() {
        @Override
        public ChartSeats createFromParcel(Parcel in) {
            return new ChartSeats(in);
        }

        @Override
        public ChartSeats[] newArray(int size) {
            return new ChartSeats[size];
        }
    };

    public ArrayList<String> getSeats() {
        return Seats;
    }

    public void setSeats(ArrayList<String> seats) {
        Seats = seats;
    }
}
