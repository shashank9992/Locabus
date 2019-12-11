package net.ticket.loca.locabus.models.bus_model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BusStatus implements Parcelable {

    private int Availability;
    private int RouteBusId;
    private ArrayList<Integer> BaseFares;
    private int TotalTax;

    public BusStatus(){}
    protected BusStatus(Parcel in) {
        Availability = in.readInt();
        RouteBusId = in.readInt();
        TotalTax = in.readInt();
        BaseFares = new ArrayList<>();
        in.readList(BaseFares, ArrayList.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Availability);
        dest.writeInt(RouteBusId);
        dest.writeInt(TotalTax);
        dest.writeList(BaseFares);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BusStatus> CREATOR = new Creator<BusStatus>() {
        @Override
        public BusStatus createFromParcel(Parcel in) {
            return new BusStatus(in);
        }

        @Override
        public BusStatus[] newArray(int size) {
            return new BusStatus[size];
        }
    };

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int availability) {
        Availability = availability;
    }

    public int getRouteBusId() {
        return RouteBusId;
    }

    public void setRouteBusId(int routeBusId) {
        RouteBusId = routeBusId;
    }

    public ArrayList<Integer> getBaseFares() {
        return BaseFares;
    }

    public void setBaseFares(ArrayList<Integer> baseFares) {
        BaseFares = baseFares;
    }

    public int getTotalTax() {
        return TotalTax;
    }

    public void setTotalTax(int totalTax) {
        TotalTax = totalTax;
    }
}
