package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class HoldRequest implements Parcelable {


    private int FromCityId;
    private int ToCityId;
    private String JourneyDate;
    private int BusId;
    private String PickUpID;
    private String DropOffID;
    private ContactInfo ContactInfo;
    private ArrayList<Passengers> Passengers;

    //Extras parmaneters Neede to show on other screens but not in request
    private Double fare;
    private String FromCityName;
    private String ToCityName;
    private String BusName;
    private String BusType;

    private String PickUpAdd;
    private String PickUpTime;
    private String DropOffAdd;
    private String DropOffTime;

    public HoldRequest(){ }

    protected HoldRequest(Parcel in) {
        FromCityId = in.readInt();
        ToCityId = in.readInt();
        JourneyDate = in.readString();
        BusId = in.readInt();
        PickUpID = in.readString();
        DropOffID = in.readString();
        ContactInfo = in.readParcelable(net.ticket.loca.locabus.models.transactions.ContactInfo.class.getClassLoader());
        Passengers = in.createTypedArrayList(net.ticket.loca.locabus.models.transactions.Passengers.CREATOR);
        if (in.readByte() == 0) {
            fare = null;
        } else {
            fare = in.readDouble();
        }
        FromCityName = in.readString();
        ToCityName = in.readString();
        BusName = in.readString();
        BusType = in.readString();
        PickUpAdd = in.readString();
        PickUpTime = in.readString();
        DropOffAdd = in.readString();
        DropOffTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(FromCityId);
        dest.writeInt(ToCityId);
        dest.writeString(JourneyDate);
        dest.writeInt(BusId);
        dest.writeString(PickUpID);
        dest.writeString(DropOffID);
        dest.writeParcelable(ContactInfo, flags);
        dest.writeTypedList(Passengers);
        if (fare == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(fare);
        }
        dest.writeString(FromCityName);
        dest.writeString(ToCityName);
        dest.writeString(BusName);
        dest.writeString(BusType);

        dest.writeString(PickUpAdd);
        dest.writeString(PickUpTime);
        dest.writeString(DropOffAdd);
        dest.writeString(DropOffTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HoldRequest> CREATOR = new Creator<HoldRequest>() {
        @Override
        public HoldRequest createFromParcel(Parcel in) {
            return new HoldRequest(in);
        }

        @Override
        public HoldRequest[] newArray(int size) {
            return new HoldRequest[size];
        }
    };

    public int getFromCityId() {
        return FromCityId;
    }

    public void setFromCityId(int fromCityId) {
        FromCityId = fromCityId;
    }

    public int getToCityId() {
        return ToCityId;
    }

    public void setToCityId(int toCityId) {
        ToCityId = toCityId;
    }

    public String getJourneyDate() {
        return JourneyDate;
    }

    public void setJourneyDate(String journeyDate) {
        JourneyDate = journeyDate;
    }

    public int getBusId() {
        return BusId;
    }

    public void setBusId(int busId) {
        BusId = busId;
    }

    public String getPickUpID() {
        return PickUpID;
    }

    public void setPickUpID(String pickUpID) {
        PickUpID = pickUpID;
    }

    public String getDropOffID() {
        return DropOffID;
    }

    public void setDropOffID(String dropOffID) {
        DropOffID = dropOffID;
    }

    public net.ticket.loca.locabus.models.transactions.ContactInfo getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(net.ticket.loca.locabus.models.transactions.ContactInfo contactInfo) {
        ContactInfo = contactInfo;
    }

    public ArrayList<net.ticket.loca.locabus.models.transactions.Passengers> getPassengers() {
        return Passengers;
    }

    public void setPassengers(ArrayList<net.ticket.loca.locabus.models.transactions.Passengers> passengers) {
        Passengers = passengers;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getFromCityName() {
        return FromCityName;
    }

    public void setFromCityName(String fromCityName) {
        FromCityName = fromCityName;
    }

    public String getToCityName() {
        return ToCityName;
    }

    public void setToCityName(String toCityName) {
        ToCityName = toCityName;
    }

    public String getBusName() {
        return BusName;
    }

    public void setBusName(String busName) {
        BusName = busName;
    }

    public String getBusType() {
        return BusType;
    }

    public void setBusType(String busType) {
        BusType = busType;
    }

    public String getPickUpAdd() {
        return PickUpAdd;
    }

    public void setPickUpAdd(String pickUpAdd) {
        PickUpAdd = pickUpAdd;
    }

    public String getDropOffAdd() {
        return DropOffAdd;
    }

    public void setDropOffAdd(String dropOffAdd) {
        DropOffAdd = dropOffAdd;
    }

    public String getPickUpTime() {
        return PickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        PickUpTime = pickUpTime;
    }

    public String getDropOffTime() {
        return DropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        DropOffTime = dropOffTime;
    }
}
