package net.ticket.loca.locabus.models.SeatDataModels;


import android.os.Parcel;
import android.os.Parcelable;

public class Info implements Parcelable {
    private String TotalSleeper;
    private String TotalSemiSleeper;
    private String TotalSeater;
    private String TotalSeats;
    private String Decks;
    private Lower Lower;
    private Upper Upper;
    private String LayoutName;

    protected Info(Parcel in) {
        TotalSleeper = in.readString();
        TotalSemiSleeper = in.readString();
        TotalSeater = in.readString();
        TotalSeats = in.readString();
        Decks = in.readString();
        Lower = in.readParcelable(Lower.class.getClassLoader());
        Upper = in.readParcelable(Upper.class.getClassLoader());
        LayoutName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TotalSleeper);
        dest.writeString(TotalSemiSleeper);
        dest.writeString(TotalSeater);
        dest.writeString(TotalSeats);
        dest.writeString(Decks);
        dest.writeParcelable(Lower, flags);
        dest.writeParcelable(Upper, flags);
        dest.writeString(LayoutName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };

    public String getTotalSleeper() {
        return TotalSleeper;
    }

    public void setTotalSleeper(String totalSleeper) {
        TotalSleeper = totalSleeper;
    }

    public String getTotalSemiSleeper() {
        return TotalSemiSleeper;
    }

    public void setTotalSemiSleeper(String totalSemiSleeper) {
        TotalSemiSleeper = totalSemiSleeper;
    }

    public String getTotalSeater() {
        return TotalSeater;
    }

    public void setTotalSeater(String totalSeater) {
        TotalSeater = totalSeater;
    }

    public String getTotalSeats() {
        return TotalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        TotalSeats = totalSeats;
    }

    public String getDecks() {
        return Decks;
    }

    public void setDecks(String decks) {
        Decks = decks;
    }

    public Lower getLower() {
        return Lower;
    }

    public void setLower(Lower lower) {
        Lower = lower;
    }

    public String getLayoutName() {
        return LayoutName;
    }

    public void setLayoutName(String layoutName) {
        LayoutName = layoutName;
    }

    public Upper getUpper() {
        return Upper;
    }

    public void setUpper(Upper upper) {
        Upper = upper;
    }
}
