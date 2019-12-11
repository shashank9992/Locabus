package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

import java.sql.Array;
import java.util.ArrayList;

public class Layout implements Parcelable {

    private ArrayList<ArrayList<Integer>> Lower;
    private ArrayList<ArrayList<Integer>> Upper;


    protected Layout(Parcel in) {
        Lower = new ArrayList<>();
        in.readList(Lower, ArrayList.class.getClassLoader());
        Upper = new ArrayList<>();
        in.readList(Upper, ArrayList.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(Lower);
        dest.writeList(Upper);
    }

    @Override
    public int describeContents() {
        return 0;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Lower.size(); i++) {
            for (int j = 0; j < Lower.get(i).size(); j++) {
                stringBuilder.append(Lower.get(i).get(j) + " ");
            }
        }
        for (int i = 0; i < Upper.size(); i++) {
            for (int j = 0; j < Upper.get(i).size(); j++) {
                stringBuilder.append(Upper.get(i).get(j) + " ");
            }
        }
        return stringBuilder.toString();
    }
}
