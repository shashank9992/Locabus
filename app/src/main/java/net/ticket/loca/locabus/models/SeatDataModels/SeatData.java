package net.ticket.loca.locabus.models.SeatDataModels;

import android.os.Parcel;
import android.os.Parcelable;

public class SeatData implements Parcelable {

    private int type ;
    private int FieldEmpty = 0;
    private String seat_name;
    private Double base_fare;
    private Double total_fare;
    private int seat_status;
    private int seat_number;
    private int seat_width = 0;
    private int seat_height = 0;

    public SeatData(){}

    protected SeatData(Parcel in) {
        type = in.readInt();
        FieldEmpty = in.readInt();
        seat_name = in.readString();
        if (in.readByte() == 0) {
            base_fare = null;
        } else {
            base_fare = in.readDouble();
        }
        if (in.readByte() == 0) {
            total_fare = null;
        } else {
            total_fare = in.readDouble();
        }
        seat_status = in.readInt();
        seat_number = in.readInt();
        seat_width = in.readInt();
        seat_height = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeInt(FieldEmpty);
        dest.writeString(seat_name);
        if (base_fare == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(base_fare);
        }
        if (total_fare == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(total_fare);
        }
        dest.writeInt(seat_status);
        dest.writeInt(seat_number);
        dest.writeInt(seat_width);
        dest.writeInt(seat_height);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SeatData> CREATOR = new Creator<SeatData>() {
        @Override
        public SeatData createFromParcel(Parcel in) {
            return new SeatData(in);
        }

        @Override
        public SeatData[] newArray(int size) {
            return new SeatData[size];
        }
    };

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getFieldEmpty() {
        return FieldEmpty;
    }

    public void setFieldEmpty(int fieldEmpty) {
        FieldEmpty = fieldEmpty;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getSeat_status() {
        return seat_status;
    }

    public void setSeat_status(int seat_status) {
        this.seat_status = seat_status;
    }

    public Double getBase_fare() {
        return base_fare;
    }

    public void setBase_fare(Double base_fare) {
        this.base_fare = base_fare;
    }

    public Double getTotal_fare() {
        return total_fare;
    }

    public void setTotal_fare(Double total_fare) {
        this.total_fare = total_fare;
    }

    public int getSeat_width() {
        return seat_width;
    }

    public void setSeat_width(int seat_width) {
        this.seat_width = seat_width;
    }

    public int getSeat_height() {
        return seat_height;
    }

    public void setSeat_height(int seat_height) {
        this.seat_height = seat_height;
    }
}
