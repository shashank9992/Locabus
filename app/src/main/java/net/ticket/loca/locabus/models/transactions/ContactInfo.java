package net.ticket.loca.locabus.models.transactions;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactInfo implements Parcelable {

    private String CustomerName;
    private String Email;
    private String Phone;
    private String Mobile;

    public ContactInfo(String CustomerName, String Email,String Phone,String Mobile) {
        this.CustomerName = CustomerName;
        this.Email = Email;
        this.Phone = Phone;
        this.Mobile = Mobile;
    }

    public ContactInfo(){}

    protected ContactInfo(Parcel in) {
        CustomerName = in.readString();
        Email = in.readString();
        Phone = in.readString();
        Mobile = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CustomerName);
        dest.writeString(Email);
        dest.writeString(Phone);
        dest.writeString(Mobile);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ContactInfo> CREATOR = new Creator<ContactInfo>() {
        @Override
        public ContactInfo createFromParcel(Parcel in) {
            return new ContactInfo(in);
        }

        @Override
        public ContactInfo[] newArray(int size) {
            return new ContactInfo[size];
        }
    };

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
