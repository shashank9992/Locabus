package net.ticket.loca.locabus.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RecomendedBusData implements Parcelable {
    private int SlepperFare,NonAcFare,Acfare,SeaterFare;

    public RecomendedBusData(){}
    public RecomendedBusData(Parcel in) {
        SlepperFare = in.readInt();
        NonAcFare = in.readInt();
        Acfare = in.readInt();
        SeaterFare = in.readInt();
    }

    public static final Creator<RecomendedBusData> CREATOR = new Creator<RecomendedBusData>() {
        @Override
        public RecomendedBusData createFromParcel(Parcel in) {
            return new RecomendedBusData(in);
        }

        @Override
        public RecomendedBusData[] newArray(int size) {
            return new RecomendedBusData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(SlepperFare);
        parcel.writeInt(NonAcFare);
        parcel.writeInt(Acfare);
        parcel.writeInt(SeaterFare);
    }


    public int getSeaterFare() {
        return SeaterFare;
    }

    public void setSeaterFare(int seaterFare) {
        SeaterFare = seaterFare;
    }

    public int getAcfare() {
        return Acfare;
    }

    public void setAcfare(int acfare) {
        Acfare = acfare;
    }

    public int getNonAcFare() {
        return NonAcFare;
    }

    public void setNonAcFare(int nonAcFare) {
        NonAcFare = nonAcFare;
    }

    public int getSlepperFare() {
        return SlepperFare;
    }

    public void setSlepperFare(int slepperFare) {
        SlepperFare = slepperFare;
    }


}
