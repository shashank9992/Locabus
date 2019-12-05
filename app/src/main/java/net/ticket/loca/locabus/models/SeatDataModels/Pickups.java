package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class Pickups implements Parcelable {

    private String Contact;
    private String Landmark;
    private String Address;
    private String PickupTime;
    private String PickupArea;
    private String PickupName;
    private String PickupCode;

    protected Pickups(Parcel in) {
        Contact = in.readString();
        Landmark = in.readString();
        Address = in.readString();
        PickupTime = in.readString();
        PickupArea = in.readString();
        PickupName = in.readString();
        PickupCode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Contact);
        dest.writeString(Landmark);
        dest.writeString(Address);
        dest.writeString(PickupTime);
        dest.writeString(PickupArea);
        dest.writeString(PickupName);
        dest.writeString(PickupCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pickups> CREATOR = new Creator<Pickups>() {
        @Override
        public Pickups createFromParcel(Parcel in) {
            return new Pickups(in);
        }

        @Override
        public Pickups[] newArray(int size) {
            return new Pickups[size];
        }
    };

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPickupTime() {
        return PickupTime;
    }

    public void setPickupTime(String pickupTime) {
        PickupTime = pickupTime;
    }

    public String getPickupArea() {
        return PickupArea;
    }

    public void setPickupArea(String pickupArea) {
        PickupArea = pickupArea;
    }

    public String getPickupName() {
        return PickupName;
    }

    public void setPickupName(String pickupName) {
        PickupName = pickupName;
    }

    public String getPickupCode() {
        return PickupCode;
    }

    public void setPickupCode(String pickupCode) {
        PickupCode = pickupCode;
    }
}
