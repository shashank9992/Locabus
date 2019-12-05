package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

public class IsCancellable implements Parcelable {

    private boolean IsCancellable;
    private int ChargePct;
    private int TotalFare;
    private int RefundAmount;

    protected IsCancellable(Parcel in) {
        IsCancellable = in.readByte() != 0;
        ChargePct = in.readInt();
        TotalFare = in.readInt();
        RefundAmount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (IsCancellable ? 1 : 0));
        dest.writeInt(ChargePct);
        dest.writeInt(TotalFare);
        dest.writeInt(RefundAmount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<net.ticket.loca.locabus.models.transactions.IsCancellable> CREATOR = new Creator<net.ticket.loca.locabus.models.transactions.IsCancellable>() {
        @Override
        public net.ticket.loca.locabus.models.transactions.IsCancellable createFromParcel(Parcel in) {
            return new IsCancellable(in);
        }

        @Override
        public net.ticket.loca.locabus.models.transactions.IsCancellable[] newArray(int size) {
            return new IsCancellable[size];
        }
    };

    public boolean isCancellable() {
        return IsCancellable;
    }

    public void setCancellable(boolean cancellable) {
        IsCancellable = cancellable;
    }

    public int getChargePct() {
        return ChargePct;
    }

    public void setChargePct(int chargePct) {
        ChargePct = chargePct;
    }

    public int getTotalFare() {
        return TotalFare;
    }

    public void setTotalFare(int totalFare) {
        TotalFare = totalFare;
    }

    public int getRefundAmount() {
        return RefundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        RefundAmount = refundAmount;
    }
}
