package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class Canc implements Parcelable {

    private int  Amt;
    private int  Pct;
    private int  Mins;

    protected Canc(Parcel in) {
        Amt = in.readInt();
        Pct = in.readInt();
        Mins = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Amt);
        dest.writeInt(Pct);
        dest.writeInt(Mins);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Canc> CREATOR = new Creator<Canc>() {
        @Override
        public Canc createFromParcel(Parcel in) {
            return new Canc(in);
        }

        @Override
        public Canc[] newArray(int size) {
            return new Canc[size];
        }
    };

    public int getAmt() {
        return Amt;
    }

    public void setAmt(int amt) {
        Amt = amt;
    }

    public int getPct() {
        return Pct;
    }

    public void setPct(int pct) {
        Pct = pct;
    }

    public int getMins() {
        return Mins;
    }

    public void setMins(int mins) {
        Mins = mins;
    }
}
