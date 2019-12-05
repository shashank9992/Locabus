package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class Upper implements Parcelable {

    private int MaxRows;
    private int MaxCols;

    protected Upper(Parcel in) {
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

    public static final Creator<Upper> CREATOR = new Creator<Upper>() {
        @Override
        public Upper createFromParcel(Parcel in) {
            return new Upper(in);
        }

        @Override
        public Upper[] newArray(int size) {
            return new Upper[size];
        }
    };

    public int getMaxRows() {
        return MaxRows;
    }

    public void setMaxRows(int maxRows) {
        MaxRows = maxRows;
    }

    public int getMaxCols() {
        return MaxCols;
    }

    public void setMaxCols(int maxCols) {
        MaxCols = maxCols;
    }
}
