package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;


public class ChartLayout implements Parcelable {

    private Info Info;
    private Layout Layout;


    protected ChartLayout(Parcel in) {
        Info = in.readParcelable(net.ticket.loca.locabus.models.SeatDataModels.Info.class.getClassLoader());
        Layout = in.readParcelable(net.ticket.loca.locabus.models.SeatDataModels.Layout.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(Info, flags);
        dest.writeParcelable(Layout, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChartLayout> CREATOR = new Creator<ChartLayout>() {
        @Override
        public ChartLayout createFromParcel(Parcel in) {
            return new ChartLayout(in);
        }

        @Override
        public ChartLayout[] newArray(int size) {
            return new ChartLayout[size];
        }
    };

    public Info getInfo() {
        return Info;
    }

    public void setInfo(Info info) {
        Info = info;
    }

    public Layout getLayout() {
        return Layout;
    }

    public void setLayout(Layout layout) {
        Layout = layout;
    }


}
