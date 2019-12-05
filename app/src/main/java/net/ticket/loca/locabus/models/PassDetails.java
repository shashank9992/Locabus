package net.ticket.loca.locabus.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class PassDetails implements Parcelable{

    private int Id;
    private int FromLocation;
    private int ToLocation;
    private int RouteNumber;
    private double TotalFare;
    private int PassengerType;
    private String PassDuration;
    private int PassType;
    private int StuId;
    private boolean IsExpired;
    private String BookingDate;
    private String ExpirationDate;
    private String FromStopEng;
    private String ToStopEng;
    private ArrayList<PassValidation> passValidations;
    public PassDetails(){}


    protected PassDetails(Parcel in) {
        Id = in.readInt();
        FromLocation = in.readInt();
        ToLocation = in.readInt();
        RouteNumber = in.readInt();
        TotalFare = in.readDouble();
        PassengerType = in.readInt();
        PassDuration = in.readString();
        PassType = in.readInt();
        StuId = in.readInt();
        IsExpired = in.readByte() != 0;
        BookingDate = in.readString();
        ExpirationDate = in.readString();
        FromStopEng = in.readString();
        ToStopEng = in.readString();
        passValidations = in.createTypedArrayList(PassValidation.CREATOR);
    }

    public static final Creator<PassDetails> CREATOR = new Creator<PassDetails>() {
        @Override
        public PassDetails createFromParcel(Parcel in) {
            return new PassDetails(in);
        }

        @Override
        public PassDetails[] newArray(int size) {
            return new PassDetails[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getFromLocation() {
        return FromLocation;
    }

    public void setFromLocation(int fromLocation) {
        FromLocation = fromLocation;
    }

    public int getToLocation() {
        return ToLocation;
    }

    public void setToLocation(int toLocation) {
        ToLocation = toLocation;
    }

    public int getRouteNumber() {
        return RouteNumber;
    }

    public void setRouteNumber(int routeNumber) {
        RouteNumber = routeNumber;
    }

    public double getTotalFare() {
        return TotalFare;
    }

    public void setTotalFare(double totalFare) {
        TotalFare = totalFare;
    }

    public int getPassengerType() {
        return PassengerType;
    }

    public void setPassengerType(int passengerType) {
        PassengerType = passengerType;
    }

    public String getPassDuration() {
        return PassDuration;
    }

    public void setPassDuration(String passDuration) {
        PassDuration = passDuration;
    }

    public int getPassType() {
        return PassType;
    }

    public void setPassType(int passType) {
        PassType = passType;
    }

    public int getStuId() {
        return StuId;
    }

    public void setStuId(int stuId) {
        StuId = stuId;
    }

    public boolean isExpired() {
        return IsExpired;
    }

    public void setExpired(boolean expired) {
        IsExpired = expired;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }


    public String getFromStopEng() {
        return FromStopEng;
    }

    public void setFromStopEng(String fromStopEng) {
        FromStopEng = fromStopEng;
    }

    public String getToStopEng() {
        return ToStopEng;
    }

    public void setToStopEng(String toStopEng) {
        ToStopEng = toStopEng;
    }

    public ArrayList<PassValidation> getPassValidations() {
        return passValidations;
    }

    public void setPassValidations(ArrayList<PassValidation> passDetails) {
        this.passValidations = passDetails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Id);
        parcel.writeInt(FromLocation);
        parcel.writeInt(ToLocation);
        parcel.writeInt(RouteNumber);
        parcel.writeDouble(TotalFare);
        parcel.writeInt(PassengerType);
        parcel.writeString(PassDuration);
        parcel.writeInt(PassType);
        parcel.writeInt(StuId);
        parcel.writeByte((byte) (IsExpired ? 1 : 0));
        parcel.writeString(BookingDate);
        parcel.writeString(ExpirationDate);
        parcel.writeString(FromStopEng);
        parcel.writeString(ToStopEng);
        parcel.writeTypedList(passValidations);
    }
}
