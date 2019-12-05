package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AbstractItem implements Parcelable {

    private String PaxVerify;
    private Boolean GstEnabled;
    private String MaxAllowedSeats;
    private String ProvId;
    private String ChartCode;
    private AvailSeats AvailSeats;
    private ChartSeats ChartSeats;
    private ChartLayout ChartLayout;
    private SeatsStatus SeatsStatus;
    private ArrayList<Pickups> Pickups;
    private ArrayList<Dropoffs> Dropoffs;
    private ArrayList<Canc> Canc;


    protected AbstractItem(Parcel in) {
        PaxVerify = in.readString();
        byte tmpGstEnabled = in.readByte();
        GstEnabled = tmpGstEnabled == 0 ? null : tmpGstEnabled == 1;
        MaxAllowedSeats = in.readString();
        ProvId = in.readString();
        ChartCode = in.readString();
        AvailSeats = in.readParcelable(AvailSeats.class.getClassLoader());
        ChartSeats = in.readParcelable(ChartSeats.class.getClassLoader());
        ChartLayout = in.readParcelable(ChartLayout.class.getClassLoader());
        SeatsStatus = in.readParcelable(SeatsStatus.class.getClassLoader());
        Pickups = in.createTypedArrayList(net.ticket.loca.locabus.models.SeatDataModels.Pickups.CREATOR);
        Dropoffs = in.createTypedArrayList(net.ticket.loca.locabus.models.SeatDataModels.Dropoffs.CREATOR);
        Canc = in.createTypedArrayList(net.ticket.loca.locabus.models.SeatDataModels.Canc.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PaxVerify);
        dest.writeByte((byte) (GstEnabled == null ? 0 : GstEnabled ? 1 : 2));
        dest.writeString(MaxAllowedSeats);
        dest.writeString(ProvId);
        dest.writeString(ChartCode);
        dest.writeParcelable(AvailSeats, flags);
        dest.writeParcelable(ChartSeats, flags);
        dest.writeParcelable(ChartLayout, flags);
        dest.writeParcelable(SeatsStatus, flags);
        dest.writeTypedList(Pickups);
        dest.writeTypedList(Dropoffs);
        dest.writeTypedList(Canc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AbstractItem> CREATOR = new Creator<AbstractItem>() {
        @Override
        public AbstractItem createFromParcel(Parcel in) {
            return new AbstractItem(in);
        }

        @Override
        public AbstractItem[] newArray(int size) {
            return new AbstractItem[size];
        }
    };

    public String getProvId() {
        return ProvId;
    }

    public void setProvId(String provId) {
        ProvId = provId;
    }

    public String getChartCode() {
        return ChartCode;
    }

    public void setChartCode(String chartCode) {
        ChartCode = chartCode;
    }

    public AvailSeats getAvailSeats() {
        return AvailSeats;
    }

    public void setAvailSeats(AvailSeats availSeats) {
        AvailSeats = availSeats;
    }

    public ChartSeats getChartSeats() {
        return ChartSeats;
    }

    public void setChartSeats(ChartSeats chartSeats) {
        ChartSeats = chartSeats;
    }

    public ChartLayout getChartLayout() {
        return ChartLayout;
    }

    public void setChartLayout(ChartLayout chartLayout) {
        ChartLayout = chartLayout;
    }

    public SeatsStatus getSeatsStatus() {
        return SeatsStatus;
    }

    public void setSeatsStatus(SeatsStatus seatsStatus) {
        SeatsStatus = seatsStatus;
    }

    public ArrayList<Pickups> getPickups() {
        return Pickups;
    }

    public void setPickups(ArrayList<Pickups> pickups) {
        Pickups = pickups;
    }

    public ArrayList<Dropoffs> getDropoffs() {
        return Dropoffs;
    }

    public void setDropoffs(ArrayList<Dropoffs> dropoffs) {
        Dropoffs = dropoffs;
    }

    public ArrayList<Canc> getCanc() {
        return Canc;
    }

    public void setCanc(ArrayList<Canc> canc) {
        Canc = canc;
    }

    public String getPaxVerify() {
        return PaxVerify;
    }

    public void setPaxVerify(String paxVerify) {
        PaxVerify = paxVerify;
    }

    public Boolean getGstEnabled() {
        return GstEnabled;
    }

    public void setGstEnabled(Boolean gstEnabled) {
        GstEnabled = gstEnabled;
    }

    public String getMaxAllowedSeats() {
        return MaxAllowedSeats;
    }

    public void setMaxAllowedSeats(String maxAllowedSeats) {
        MaxAllowedSeats = maxAllowedSeats;
    }
}
