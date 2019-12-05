package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class Lower implements Parcelable {

    private int MaxRows;
    private int MaxCols;

    protected Lower(Parcel in) {
        MaxRows = in.readInt();
        MaxCols = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(MaxRows);
        dest.writeInt(MaxCols);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Lower> CREATOR = new Creator<Lower>() {
        @Override
        public Lower createFromParcel(Parcel in) {
            return new Lower(in);
        }

        @Override
        public Lower[] newArray(int size) {
            return new Lower[size];
        }
    };

    public int getMaxCols() {
        return MaxCols;
    }

    public void setMaxCols(int maxCols) {
        MaxCols = maxCols;
    }

    public int getMaxRows() {
        return MaxRows;
    }

    public void setMaxRows(int maxRows) {
        MaxRows = maxRows;
    }
}