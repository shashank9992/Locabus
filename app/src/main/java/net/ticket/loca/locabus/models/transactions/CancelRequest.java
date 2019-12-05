package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

public class CancelRequest implements Parcelable {

    private String PNR;
    private String TicketNo;
    private String SeatNos;

    protected CancelRequest(Parcel in) {
        PNR = in.readString();
        TicketNo = in.readString();
        SeatNos = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PNR);
        dest.writeString(TicketNo);
        dest.writeString(SeatNos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CancelRequest> CREATOR = new Creator<CancelRequest>() {
        @Override
        public CancelRequest createFromParcel(Parcel in) {
            return new CancelRequest(in);
        }

        @Override
        public CancelRequest[] newArray(int size) {
            return new CancelRequest[size];
        }
    };

    public String getPNR() {
        return PNR;
    }

    public void setPNR(String PNR) {
        this.PNR = PNR;
    }

    public String getTicketNo() {
        return TicketNo;
    }

    public void setTicketNo(String ticketNo) {
        TicketNo = ticketNo;
    }

    public String getSeatNos() {
        return SeatNos;
    }

    public void setSeatNos(String seatNos) {
        SeatNos = seatNos;
    }
}
