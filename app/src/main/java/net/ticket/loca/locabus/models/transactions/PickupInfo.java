package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

public class PickupInfo implements Parcelable {

    private String PickupTime;
    private String Address;
    private String Phone;
    private String Landmark;
    private String PickupName;

    protected PickupInfo(Parcel in) {
        PickupTime = in.readString();
        Address = in.readString();
        Phone = in.readString();
        Landmark = in.readString();
        PickupName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PickupTime);
        dest.writeString(Address);
        dest.writeString(Phone);
        dest.writeString(Landmark);
        dest.writeString(PickupName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PickupInfo> CREATOR = new Creator<PickupInfo>() {
        @Override
        public PickupInfo createFromParcel(Parcel in) {
            return new PickupInfo(in);
        }

        @Override
        public PickupInfo[] newArray(int size) {
            return new PickupInfo[size];
        }
    };

    public String getPickupTime() {
        return PickupTime;
    }

    public void setPickupTime(String pickupTime) {
        PickupTime = pickupTime;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }

    public String getPickupName() {
        return PickupName;
    }

    public void setPickupName(String pickupName) {
        PickupName = pickupName;
    }
}
