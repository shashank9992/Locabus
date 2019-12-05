package net.ticket.loca.locabus.models.bus_model;

import android.os.Parcel;
import android.os.Parcelable;
import net.ticket.loca.locabus.models.SeatDataModels.Canc;
import net.ticket.loca.locabus.models.SeatDataModels.Dropoffs;
import net.ticket.loca.locabus.models.SeatDataModels.Pickups;


import java.util.ArrayList;

public class Buses implements Parcelable {

    private boolean NonRefundable;
    private boolean MTicket;
    private int CompanyId;
    private int ProvCompId;
    private int ProvId;
    private int RouteBusId;
    private BusType BusType;
    private ArrayList<net.ticket.loca.locabus.models.SeatDataModels.Pickups> Pickups;
    private ArrayList<net.ticket.loca.locabus.models.SeatDataModels.Dropoffs> Dropoffs;
    private ArrayList<net.ticket.loca.locabus.models.SeatDataModels.Canc> Canc;
    private ArrayList<Integer> Amenities;
    private BusStatus BusStatus;
    private boolean Visibility;
    private float CommPct;
    private String DisplayBusType;
    private String ToName;
    private String FromName;
    private String ChartCode;
    private String Duration;
    private String BusLabel;
    private String CompanyName;
    private String ArrTime;
    private String DeptTime;
    private String TripId;

    public Buses(){}

    protected Buses(Parcel in) {
        NonRefundable = in.readByte() != 0;
        MTicket = in.readByte() != 0;
        CompanyId = in.readInt();
        ProvCompId = in.readInt();
        ProvId = in.readInt();
        RouteBusId = in.readInt();
        BusType = in.readParcelable( BusType.class.getClassLoader());
        Pickups = in.createTypedArrayList(net.ticket.loca.locabus.models.SeatDataModels.Pickups.CREATOR);
        Dropoffs = in.createTypedArrayList(net.ticket.loca.locabus.models.SeatDataModels.Dropoffs.CREATOR);
        Canc = in.createTypedArrayList(net.ticket.loca.locabus.models.SeatDataModels.Canc.CREATOR);
        BusStatus = in.readParcelable( BusStatus.class.getClassLoader());
        Visibility = in.readByte() != 0;
        CommPct = in.readInt();
        DisplayBusType = in.readString();
        ToName = in.readString();
        FromName = in.readString();
        ChartCode = in.readString();
        Duration = in.readString();
        BusLabel = in.readString();
        CompanyName = in.readString();
        ArrTime = in.readString();
        DeptTime = in.readString();
        TripId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (NonRefundable ? 1 : 0));
        dest.writeByte((byte) (MTicket ? 1 : 0));
        dest.writeInt(CompanyId);
        dest.writeInt(ProvCompId);
        dest.writeInt(ProvId);
        dest.writeInt(RouteBusId);
        dest.writeParcelable(BusType, flags);
        dest.writeTypedList(Pickups);
        dest.writeTypedList(Dropoffs);
        dest.writeTypedList(Canc);
        dest.writeParcelable(BusStatus, flags);
        dest.writeByte((byte) (Visibility ? 1 : 0));
        dest.writeFloat(CommPct);
        dest.writeString(DisplayBusType);
        dest.writeString(ToName);
        dest.writeString(FromName);
        dest.writeString(ChartCode);
        dest.writeString(Duration);
        dest.writeString(BusLabel);
        dest.writeString(CompanyName);
        dest.writeString(ArrTime);
        dest.writeString(DeptTime);
        dest.writeString(TripId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Buses> CREATOR = new Creator<Buses>() {
        @Override
        public Buses createFromParcel(Parcel in) {
            return new Buses(in);
        }

        @Override
        public Buses[] newArray(int size) {
            return new Buses[size];
        }
    };

    public boolean isNonRefundable() {
        return NonRefundable;
    }

    public void setNonRefundable(boolean nonRefundable) {
        NonRefundable = nonRefundable;
    }

    public boolean isMTicket() {
        return MTicket;
    }

    public void setMTicket(boolean MTicket) {
        this.MTicket = MTicket;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public int getProvCompId() {
        return ProvCompId;
    }

    public void setProvCompId(int provCompId) {
        ProvCompId = provCompId;
    }

    public int getProvId() {
        return ProvId;
    }

    public void setProvId(int provId) {
        ProvId = provId;
    }

    public int getRouteBusId() {
        return RouteBusId;
    }

    public void setRouteBusId(int routeBusId) {
        RouteBusId = routeBusId;
    }

    public  BusType getBusType() {
        return BusType;
    }

    public void setBusType( BusType busType) {
        BusType = busType;
    }

    public ArrayList< Pickups> getPickups() {
        return Pickups;
    }

    public void setPickups(ArrayList< Pickups> pickups) {
        Pickups = pickups;
    }

    public ArrayList<net.ticket.loca.locabus.models.SeatDataModels.Dropoffs> getDropoffs() {
        return Dropoffs;
    }

    public void setDropoffs(ArrayList< Dropoffs> dropoffs) {
        Dropoffs = dropoffs;
    }

    public ArrayList< Canc> getCanc() {
        return Canc;
    }

    public void setCanc(ArrayList< Canc> canc) {
        Canc = canc;
    }

    public ArrayList<Integer> getAmenities() {
        return Amenities;
    }

    public void setAmenities(ArrayList<Integer> amenities) {
        Amenities = amenities;
    }

    public  BusStatus getBusStatus() {
        return BusStatus;
    }

    public void setBusStatus( BusStatus busStatus) {
        BusStatus = busStatus;
    }

    public boolean isVisibility() {
        return Visibility;
    }

    public void setVisibility(boolean visibility) {
        Visibility = visibility;
    }

    public float getCommPct() {
        return CommPct;
    }

    public void setCommPct(float commPct) {
        CommPct = commPct;
    }

    public String getDisplayBusType() {
        return DisplayBusType;
    }

    public void setDisplayBusType(String displayBusType) {
        DisplayBusType = displayBusType;
    }

    public String getToName() {
        return ToName;
    }

    public void setToName(String toName) {
        ToName = toName;
    }

    public String getFromName() {
        return FromName;
    }

    public void setFromName(String fromName) {
        FromName = fromName;
    }

    public String getChartCode() {
        return ChartCode;
    }

    public void setChartCode(String chartCode) {
        ChartCode = chartCode;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getBusLabel() {
        return BusLabel;
    }

    public void setBusLabel(String busLabel) {
        BusLabel = busLabel;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getArrTime() {
        return ArrTime;
    }

    public void setArrTime(String arrTime) {
        ArrTime = arrTime;
    }

    public String getDeptTime() {
        return DeptTime;
    }

    public void setDeptTime(String deptTime) {
        DeptTime = deptTime;
    }

    public String getTripId() {
        return TripId;
    }

    public void setTripId(String tripId) {
        TripId = tripId;
    }
}
