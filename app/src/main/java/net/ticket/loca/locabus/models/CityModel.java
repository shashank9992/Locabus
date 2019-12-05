package net.ticket.loca.locabus.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CityModel implements Parcelable {

    private int CityId;
    private String City;
    private String State;

    protected CityModel(Parcel in) {
        CityId = in.readInt();
        City = in.readString();
        State = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CityId);
        dest.writeString(City);
        dest.writeString(State);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CityModel> CREATOR = new Creator<CityModel>() {
        @Override
        public CityModel createFromParcel(Parcel in) {
            return new CityModel(in);
        }

        @Override
        public CityModel[] newArray(int size) {
            return new CityModel[size];
        }
    };

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
