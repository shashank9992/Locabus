package net.ticket.loca.locabus.models;

import android.os.Parcel;
import android.os.Parcelable;

public class LocalTicketDetails implements Parcelable {

    private int Id;
    private int FromLocation;
    private int ToLocation;
    private int RouteNumber;
    private String Fare;
    private int AdultCount;
    private int ChildCount;
    private int LuggageCount;
    private String TotalFare;
    private boolean IsExpired;
    private boolean IsValidated;
    private boolean IsInspected;
    private String BookingDate;
    private String ExpirationDate;
    private String EmployeeId;
    private String VerificationDate;
    private String InspectionDate;
    private String InspectorId;
    private String SourceName;
    private String DestinationName;

    protected LocalTicketDetails(Parcel in) {
        Id = in.readInt();
        FromLocation = in.readInt();
        ToLocation = in.readInt();
        RouteNumber = in.readInt();
        Fare = in.readString();
        AdultCount = in.readInt();
        ChildCount = in.readInt();
        LuggageCount = in.readInt();
        TotalFare = in.readString();
        IsExpired = in.readByte() != 0;
        IsValidated = in.readByte() != 0;
        IsInspected = in.readByte() != 0;
        BookingDate = in.readString();
        ExpirationDate = in.readString();
        EmployeeId = in.readString();
        VerificationDate = in.readString();
        InspectionDate = in.readString();
        InspectorId = in.readString();
        SourceName = in.readString();
        DestinationName = in.readString();
    }

    public static final Creator<LocalTicketDetails> CREATOR = new Creator<LocalTicketDetails>() {
        @Override
        public LocalTicketDetails createFromParcel(Parcel in) {
            return new LocalTicketDetails(in);
        }

        @Override
        public LocalTicketDetails[] newArray(int size) {
            return new LocalTicketDetails[size];
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

    public String getFare() {
        return Fare;
    }

    public void setFare(String fare) {
        Fare = fare;
    }

    public int getAdultCount() {
        return AdultCount;
    }

    public void setAdultCount(int adultCount) {
        AdultCount = adultCount;
    }

    public int getChildCount() {
        return ChildCount;
    }

    public void setChildCount(int childCount) {
        ChildCount = childCount;
    }

    public int getLuggageCount() {
        return LuggageCount;
    }

    public void setLuggageCount(int luggageCount) {
        LuggageCount = luggageCount;
    }

    public String getTotalFare() {
        return TotalFare;
    }

    public void setTotalFare(String totalFare) {
        TotalFare = totalFare;
    }

    public boolean isExpired() {
        return IsExpired;
    }

    public void setExpired(boolean expired) {
        IsExpired = expired;
    }

    public boolean isValidated() {
        return IsValidated;
    }

    public void setValidated(boolean validated) {
        IsValidated = validated;
    }

    public boolean isInspected() {
        return IsInspected;
    }

    public void setInspected(boolean inspected) {
        IsInspected = inspected;
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

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getVerificationDate() {
        return VerificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        VerificationDate = verificationDate;
    }

    public String getInspectionDate() {
        return InspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        InspectionDate = inspectionDate;
    }

    public String getInspectorId() {
        return InspectorId;
    }

    public String getSourceName() {
        return SourceName;
    }

    public String getDestinationName() {
        return DestinationName;
    }

    public void setInspectorId(String inspectorId) {
        InspectorId = inspectorId;
    }

    public void setSourceName(String sourceName) {
        SourceName = sourceName;
    }
    public void setDestinationName(String destinationName) {
        DestinationName = destinationName;
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
        parcel.writeString(Fare);
        parcel.writeInt(AdultCount);
        parcel.writeInt(ChildCount);
        parcel.writeInt(LuggageCount);
        parcel.writeString(TotalFare);
        parcel.writeByte((byte) (IsExpired ? 1 : 0));
        parcel.writeByte((byte) (IsValidated ? 1 : 0));
        parcel.writeByte((byte) (IsInspected ? 1 : 0));
        parcel.writeString(BookingDate);
        parcel.writeString(ExpirationDate);
        parcel.writeString(EmployeeId);
        parcel.writeString(VerificationDate);
        parcel.writeString(InspectionDate);
        parcel.writeString(InspectorId);
        parcel.writeString(SourceName);
        parcel.writeString(DestinationName);
    }
}
