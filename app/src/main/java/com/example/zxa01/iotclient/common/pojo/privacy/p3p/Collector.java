package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public class Collector implements Parcelable {

    private long id;
    private String name;
    private String phone;
    private String email;

    public Collector() {
    }

    protected Collector(Parcel in) {
        id = in.readLong();
        name = in.readString();
        phone = in.readString();
        email = in.readString();
    }

    public static final Creator<Collector> CREATOR = new Creator<Collector>() {
        @Override
        public Collector createFromParcel(Parcel in) {
            return new Collector(in);
        }

        @Override
        public Collector[] newArray(int size) {
            return new Collector[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(email);
    }

    public long getId() {
        return id;
    }

    public Collector setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Collector setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Collector setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Collector setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collector collector = (Collector) o;

        if (id != collector.id) return false;
        if (name != null ? !name.equals(collector.name) : collector.name != null) return false;
        if (phone != null ? !phone.equals(collector.phone) : collector.phone != null) return false;
        return email != null ? email.equals(collector.email) : collector.email == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
