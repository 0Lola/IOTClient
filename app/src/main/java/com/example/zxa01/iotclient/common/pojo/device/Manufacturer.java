package com.example.zxa01.iotclient.common.pojo.device;

import android.os.Parcel;
import android.os.Parcelable;

public class Manufacturer implements Parcelable, Cloneable {

    private long id;
    private String name;
    private String url;
    private String serialNumber;

    public Manufacturer() {
    }

    public Manufacturer(Manufacturer manufacturer) {
        this.setId(manufacturer.id)
                .setName(manufacturer.name)
                .setSerialNumber(manufacturer.serialNumber)
                .setUrl(manufacturer.url);
    }

    private Manufacturer(Parcel in) {
        id = in.readLong();
        name = in.readString();
        url = in.readString();
        serialNumber = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(serialNumber);
    }

    public static final Creator<Manufacturer> CREATOR = new Creator<Manufacturer>() {
        @Override
        public Manufacturer createFromParcel(Parcel in) {
            return new Manufacturer(in);
        }

        @Override
        public Manufacturer[] newArray(int size) {
            return new Manufacturer[size];
        }
    };

    public long getId() {
        return id;
    }

    public Manufacturer setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Manufacturer setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Manufacturer setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Manufacturer setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        return serialNumber != null ? serialNumber.equals(that.serialNumber) : that.serialNumber == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
