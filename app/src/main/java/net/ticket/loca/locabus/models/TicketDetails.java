package net.ticket.loca.locabus.models;

import android.os.Parcel;
import android.os.Parcelable;
import net.ticket.loca.locabus.models.transactions.HoldRequest;

public class TicketDetails implements Parcelable {

    private int ticket_id;
    private String holding_id;
    private String ticket_pnr;
    private String ticket_booking_id;
    private String track_id;
    private int isCancel;
    private int hold;
    private HoldRequest holdItems;

    public TicketDetails(){ }

    protected TicketDetails(Parcel in) {
        ticket_id = in.readInt();
        holding_id = in.readString();
        ticket_pnr = in.readString();
        ticket_booking_id = in.readString();
        track_id = in.readString();
        isCancel = in.readInt();
        hold = in.readInt();
        holdItems = in.readParcelable(HoldRequest.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ticket_id);
        dest.writeString(holding_id);
        dest.writeString(ticket_pnr);
        dest.writeString(ticket_booking_id);
        dest.writeString(track_id);
        dest.writeInt(isCancel);
        dest.writeInt(hold);
        dest.writeParcelable(holdItems, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TicketDetails> CREATOR = new Creator<TicketDetails>() {
        @Override
        public TicketDetails createFromParcel(Parcel in) {
            return new TicketDetails(in);
        }

        @Override
        public TicketDetails[] newArray(int size) {
            return new TicketDetails[size];
        }
    };

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getHolding_id() {
        return holding_id;
    }

    public void setHolding_id(String holding_id) {
        this.holding_id = holding_id;
    }

    public String getTicket_pnr() {
        return ticket_pnr;
    }

    public void setTicket_pnr(String ticket_pnr) {
        this.ticket_pnr = ticket_pnr;
    }

    public String getTicket_booking_id() {
        return ticket_booking_id;
    }

    public void setTicket_booking_id(String ticket_booking_id) {
        this.ticket_booking_id = ticket_booking_id;
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public int getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(int isCancel) {
        this.isCancel = isCancel;
    }

    public HoldRequest getHoldItems() {
        return holdItems;
    }

    public void setHoldItems(HoldRequest holdItems) {
        this.holdItems = holdItems;
    }

    public int getHold() {
        return hold;
    }

    public void setHold(int hold) {
        this.hold = hold;
    }
}
