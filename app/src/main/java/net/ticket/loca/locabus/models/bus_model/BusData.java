package net.ticket.loca.locabus.models.bus_model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BusData implements Parcelable {

    private int ToCityId;
    private int FromCityId;
    private ArrayList<Buses> Buses;
    private ArrayList<String> AllAmenities;
    private String JourneyDate;



    protected BusData(Parcel in) {
        ToCityId = in.readInt();
        FromCityId = in.readInt();
        Buses = in.createTypedArrayList(net.ticket.loca.locabus.models.bus_model.Buses.CREATOR);
        AllAmenities = in.createStringArrayList();
        JourneyDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ToCityId);
        dest.writeInt(FromCityId);
        dest.writeTypedList(Buses);
        dest.writeStringList(AllAmenities);
        dest.writeString(JourneyDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BusData> CREATOR = new Creator<BusData>() {
        @Override
        public BusData createFromParcel(Parcel in) {
            return new BusData(in);
        }

        @Override
        public BusData[] newArray(int size) {
            return new BusData[size];
        }
    };

    public int getToCityId() {
        return ToCityId;
    }

    public void setToCityId(int toCityId) {
        ToCityId = toCityId;
    }

    public int getFromCityId() {
        return FromCityId;
    }

    public void setFromCityId(int fromCityId) {
        FromCityId = fromCityId;
    }

    public ArrayList<Buses> getBuses() {
        return Buses;
    }

    public void setBuses(ArrayList<Buses> buses) {
        Buses = buses;
    }

    public ArrayList<String> getAllAmenities() {
        return AllAmenities;
    }

    public void setAllAmenities(ArrayList<String> allAmenities) {
        AllAmenities = allAmenities;
    }

    public String getJourneyDate() {
        return JourneyDate;
    }

    public void setJourneyDate(String journeyDate) {
        JourneyDate = journeyDate;
    }
}
