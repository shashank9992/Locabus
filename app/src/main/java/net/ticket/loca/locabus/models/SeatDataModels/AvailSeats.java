package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class AvailSeats implements Parcelable {

    private int Upper;
    private int Lower;

    protected AvailSeats(Parcel in) {
        Upper = in.readInt();
        Lower = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Upper);
        dest.writeInt(Lower);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AvailSeats> CREATOR = new Creator<AvailSeats>() {
        @Override
        public AvailSeats createFromParcel(Parcel in) {
            return new AvailSeats(in);
        }

        @Override
        public AvailSeats[] newArray(int size) {
            return new AvailSeats[size];
        }
    };

    public int getUpper() {
        return Upper;
    }

    public void setUpper(int upper) {
        Upper = upper;
    }

    public int getLower() {
        return Lower;
    }

    public void setLower(int lower) {
        Lower = lower;
    }
}
