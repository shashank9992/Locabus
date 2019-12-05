package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

public class Passengers implements Parcelable {

    private String Name;
    private int Age;
    private String Gender;
    private String SeatNo;
    private Double Fare;
    private int SeatTypeId;
    private boolean IsAcSeat;

    public Passengers(){

    }

    protected Passengers(Parcel in) {
        Name = in.readString();
        Age = in.readInt();
        Gender = in.readString();
        SeatNo = in.readString();
        if (in.readByte() == 0) {
            Fare = null;
        } else {
            Fare = in.readDouble();
        }
        SeatTypeId = in.readInt();
        IsAcSeat = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeInt(Age);
        dest.writeString(Gender);
        dest.writeString(SeatNo);
        if (Fare == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(Fare);
        }
        dest.writeInt(SeatTypeId);
        dest.writeByte((byte) (IsAcSeat ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Passengers> CREATOR = new Creator<Passengers>() {
        @Override
        public Passengers createFromParcel(Parcel in) {
            return new Passengers(in);
        }

        @Override
        public Passengers[] newArray(int size) {
            return new Passengers[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(String seatNo) {
        SeatNo = seatNo;
    }

    public Double getFare() {
        return Fare;
    }

    public void setFare(Double fare) {
        Fare = fare;
    }

    public int getSeatTypeId() {
        return SeatTypeId;
    }

    public void setSeatTypeId(int seatTypeId) {
        SeatTypeId = seatTypeId;
    }

    public boolean isAcSeat() {
        return IsAcSeat;
    }

    public void setAcSeat(boolean acSeat) {
        IsAcSeat = acSeat;
    }
}
