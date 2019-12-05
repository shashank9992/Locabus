package net.ticket.loca.locabus.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PassValidation implements Parcelable {

    private int Id;
    private int PassId;
    private String PunchTime;
    private int ConductorId;
    private String Waybill;

    public PassValidation(){}

    protected PassValidation(Parcel in) {
        Id = in.readInt();
        PassId = in.readInt();
        PunchTime = in.readString();
        ConductorId = in.readInt();
        Waybill = in.readString();
    }

    public static final Creator<PassValidation> CREATOR = new Creator<PassValidation>() {
        @Override
        public PassValidation createFromParcel(Parcel in) {
            return new PassValidation(in);
        }

        @Override
        public PassValidation[] newArray(int size) {
            return new PassValidation[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPassId() {
        return PassId;
    }

    public void setPassId(int passId) {
        PassId = passId;
    }

    public String getPunchTime() {
        return PunchTime;
    }

    public void setPunchTime(String punchTime) {
        PunchTime = punchTime;
    }

    public int getConductorId() {
        return ConductorId;
    }

    public void setConductorId(int conductorId) {
        ConductorId = conductorId;
    }

    public String getWaybill() {
        return Waybill;
    }

    public void setWaybill(String waybill) {
        Waybill = waybill;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Id);
        parcel.writeInt(PassId);
        parcel.writeString(PunchTime);
        parcel.writeInt(ConductorId);
        parcel.writeString(Waybill);
    }
}
