package net.ticket.loca.locabus.models.bus_model;

import android.os.Parcel;
import android.os.Parcelable;

public class BusType implements Parcelable {

    private String IsAC;
    private String Seating;
    private String Make;
    private String Axle;
    private String Axel;

    public BusType(){

    }

    protected BusType(Parcel in) {
        IsAC = in.readString();
        Seating = in.readString();
        Make = in.readString();
        Axle = in.readString();
        Axel = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(IsAC);
        dest.writeString(Seating);
        dest.writeString(Make);
        dest.writeString(Axle);
        dest.writeString(Axel);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BusType> CREATOR = new Creator<BusType>() {
        @Override
        public BusType createFromParcel(Parcel in) {
            return new BusType(in);
        }

        @Override
        public BusType[] newArray(int size) {
            return new BusType[size];
        }
    };

    public String getIsAC() {
        return IsAC;
    }

    public void setIsAC(String isAC) {
        IsAC = isAC;
    }

    public String getSeating() {
        return Seating;
    }

    public void setSeating(String seating) {
        Seating = seating;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getAxle() {
        return Axle;
    }

    public void setAxle(String axle) {
        Axle = axle;
    }

    public String getAxel() {
        return Axel;
    }

    public void setAxel(String axel) {
        Axel = axel;
    }
}
