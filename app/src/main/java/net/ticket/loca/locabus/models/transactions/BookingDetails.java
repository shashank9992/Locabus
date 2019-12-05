package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BookingDetails implements Parcelable {

    private boolean IsCancelled;
    private int TotalFare;
    private int TotalSeats;
    private net.ticket.loca.locabus.models.transactions.PickupInfo PickupInfo;
    private ArrayList<net.ticket.loca.locabus.models.transactions.Passengers> Passengers;
    private ContactInfo ContactInfo;
    private String BusTypeName;
    private String DepartureDateTime;
    private String ArrivalDateTime;
    private String JourneyDate;
    private String ToCityName;
    private String FromCityName;
    private String CompanyName;
    private String TicketNo;
    private String PNRNo;

    protected BookingDetails(Parcel in) {
        IsCancelled = in.readByte() != 0;
        TotalFare = in.readInt();
        TotalSeats = in.readInt();
        PickupInfo = in.readParcelable(net.ticket.loca.locabus.models.transactions.PickupInfo.class.getClassLoader());
        Passengers = in.createTypedArrayList(net.ticket.loca.locabus.models.transactions.Passengers.CREATOR);
        ContactInfo = in.readParcelable(net.ticket.loca.locabus.models.transactions.ContactInfo.class.getClassLoader());
        BusTypeName = in.readString();
        DepartureDateTime = in.readString();
        ArrivalDateTime = in.readString();
        JourneyDate = in.readString();
        ToCityName = in.readString();
        FromCityName = in.readString();
        CompanyName = in.readString();
        TicketNo = in.readString();
        PNRNo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (IsCancelled ? 1 : 0));
        dest.writeInt(TotalFare);
        dest.writeInt(TotalSeats);
        dest.writeParcelable(PickupInfo, flags);
        dest.writeTypedList(Passengers);
        dest.writeParcelable(ContactInfo, flags);
        dest.writeString(BusTypeName);
        dest.writeString(DepartureDateTime);
        dest.writeString(ArrivalDateTime);
        dest.writeString(JourneyDate);
        dest.writeString(ToCityName);
        dest.writeString(FromCityName);
        dest.writeString(CompanyName);
        dest.writeString(TicketNo);
        dest.writeString(PNRNo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BookingDetails> CREATOR = new Creator<BookingDetails>() {
        @Override
        public BookingDetails createFromParcel(Parcel in) {
            return new BookingDetails(in);
        }

        @Override
        public BookingDetails[] newArray(int size) {
            return new BookingDetails[size];
        }
    };

    public boolean isCancelled() {
        return IsCancelled;
    }

    public void setCancelled(boolean cancelled) {
        IsCancelled = cancelled;
    }

    public int getTotalFare() {
        return TotalFare;
    }

    public void setTotalFare(int totalFare) {
        TotalFare = totalFare;
    }

    public int getTotalSeats() {
        return TotalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        TotalSeats = totalSeats;
    }

    public net.ticket.loca.locabus.models.transactions.PickupInfo getPickupInfo() {
        return PickupInfo;
    }

    public void setPickupInfo(net.ticket.loca.locabus.models.transactions.PickupInfo pickupInfo) {
        PickupInfo = pickupInfo;
    }

    public ArrayList<net.ticket.loca.locabus.models.transactions.Passengers> getPassengers() {
        return Passengers;
    }

    public void setPassengers(ArrayList<net.ticket.loca.locabus.models.transactions.Passengers> passengers) {
        Passengers = passengers;
    }

    public net.ticket.loca.locabus.models.transactions.ContactInfo getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(net.ticket.loca.locabus.models.transactions.ContactInfo contactInfo) {
        ContactInfo = contactInfo;
    }

    public String getBusTypeName() {
        return BusTypeName;
    }

    public void setBusTypeName(String busTypeName) {
        BusTypeName = busTypeName;
    }

    public String getDepartureDateTime() {
        return DepartureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        DepartureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return ArrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        ArrivalDateTime = arrivalDateTime;
    }

    public String getJourneyDate() {
        return JourneyDate;
    }

    public void setJourneyDate(String journeyDate) {
        JourneyDate = journeyDate;
    }

    public String getToCityName() {
        return ToCityName;
    }

    public void setToCityName(String toCityName) {
        ToCityName = toCityName;
    }

    public String getFromCityName() {
        return FromCityName;
    }

    public void setFromCityName(String fromCityName) {
        FromCityName = fromCityName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getTicketNo() {
        return TicketNo;
    }

    public void setTicketNo(String ticketNo) {
        TicketNo = ticketNo;
    }

    public String getPNRNo() {
        return PNRNo;
    }

    public void setPNRNo(String PNRNo) {
        this.PNRNo = PNRNo;
    }
}
