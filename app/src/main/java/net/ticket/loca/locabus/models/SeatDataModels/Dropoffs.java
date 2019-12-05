package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class Dropoffs implements Parcelable {

    private String DropoffTime;
    private String DropoffName;
    private String DropoffCode;

    protected Dropoffs(Parcel in) {
        DropoffTime = in.readString();
        DropoffName = in.readString();
        DropoffCode = in.readString();
    }

    public static final Creator<Dropoffs> CREATOR = new Creator<Dropoffs>() {
        @Override
        public Dropoffs createFromParcel(Parcel in) {
            return new Dropoffs(in);
        }

        @Override
        public Dropoffs[] newArray(int size) {
            return new Dropoffs[size];
        }
    };

    public String getDropoffTime() {
        return DropoffTime;
    }

    public void setDropoffTime(String dropoffTime) {
        DropoffTime = dropoffTime;
    }

    public String getDropoffName() {
        return DropoffName;
    }

    public void setDropoffName(String dropoffName) {
        DropoffName = dropoffName;
    }

    public String getDropoffCode() {
        return DropoffCode;
    }

    public void setDropoffCode(String dropoffCode) {
        DropoffCode = dropoffCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(DropoffTime);
        parcel.writeString(DropoffName);
        parcel.writeString(DropoffCode);
    }
}
