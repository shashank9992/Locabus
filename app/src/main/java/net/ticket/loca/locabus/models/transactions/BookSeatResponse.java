package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

public class BookSeatResponse implements Parcelable {

    private int HoldId;
    private int TotalFare;
    private String TicketNo;
    private String PNRNo;
    private String Message;

    protected BookSeatResponse(Parcel in) {
        HoldId = in.readInt();
        TotalFare = in.readInt();
        TicketNo = in.readString();
        PNRNo = in.readString();
        Message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(HoldId);
        dest.writeInt(TotalFare);
        dest.writeString(TicketNo);
        dest.writeString(PNRNo);
        dest.writeString(Message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BookSeatResponse> CREATOR = new Creator<BookSeatResponse>() {
        @Override
        public BookSeatResponse createFromParcel(Parcel in) {
            return new BookSeatResponse(in);
        }

        @Override
        public BookSeatResponse[] newArray(int size) {
            return new BookSeatResponse[size];
        }
    };

    public int getHoldId() {
        return HoldId;
    }

    public void setHoldId(int holdId) {
        HoldId = holdId;
    }

    public int getTotalFare() {
        return TotalFare;
    }

    public void setTotalFare(int totalFare) {
        TotalFare = totalFare;
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

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
