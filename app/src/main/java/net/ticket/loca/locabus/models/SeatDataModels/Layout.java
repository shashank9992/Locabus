package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Layout implements Parcelable {

    private ArrayList<ArrayList<Integer>> Lower;
    private ArrayList<ArrayList<Integer>> Upper;

    protected Layout(Parcel in) {
    }

    public static final Creator<Layout> CREATOR = new Creator<Layout>() {
        @Override
        public Layout createFromParcel(Parcel in) {
            return new Layout(in);
        }

        @Override
        public Layout[] newArray(int size) {
            return new Layout[size];
        }
    };

    public ArrayList<ArrayList<Integer>> getLower() {
        return Lower;
    }

    public void setLower(ArrayList<ArrayList<Integer>> lower) {
        Lower = lower;
    }

    public ArrayList<ArrayList<Integer>> getUpper() {
        return Upper;
    }

    public void setUpper(ArrayList<ArrayList<Integer>> upper) {
        Upper = upper;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
