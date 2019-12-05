package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class SeatsStatus implements Parcelable {

    private ArrayList<Integer> Status;
    private ArrayList<ArrayList<Double>> Fares;
    private ArrayList<Integer> UniqFares;
    private String profiler;

    protected SeatsStatus(Parcel in) {
        profiler = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(profiler);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SeatsStatus> CREATOR = new Creator<SeatsStatus>() {
        @Override
        public SeatsStatus createFromParcel(Parcel in) {
            return new SeatsStatus(in);
        }

        @Override
        public SeatsStatus[] newArray(int size) {
            return new SeatsStatus[size];
        }
    };

    public ArrayList<Integer> getStatus() {
        return Status;
    }

    public void setStatus(ArrayList<Integer> status) {
        Status = status;
    }

    public ArrayList<ArrayList<Double>> getFares() {
        return Fares;
    }

    public void setFares(ArrayList<ArrayList<Double>> fares) {
        Fares = fares;
    }

    public ArrayList<Integer> getUniqFares() {
        return UniqFares;
    }

    public void setUniqFares(ArrayList<Integer> uniqFares) {
        UniqFares = uniqFares;
    }

    public String getProfiler() {
        return profiler;
    }

    public void setProfiler(String profiler) {
        this.profiler = profiler;
    }
}
