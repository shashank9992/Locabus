package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class IntArrayVal implements Parcelable{

    private int[] int_array;

    protected IntArrayVal(Parcel in) {
        int_array = in.createIntArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(int_array);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IntArrayVal> CREATOR = new Creator<IntArrayVal>() {
        @Override
        public IntArrayVal createFromParcel(Parcel in) {
            return new IntArrayVal(in);
        }

        @Override
        public IntArrayVal[] newArray(int size) {
            return new IntArrayVal[size];
        }
    };

    public int[] getInt_array() {
        return int_array;
    }

    public void setInt_array(int[] int_array) {
        this.int_array = int_array;
    }
}
