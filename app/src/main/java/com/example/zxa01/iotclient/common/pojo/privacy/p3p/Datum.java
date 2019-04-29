package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public class Datum implements Parcelable {

    private long id;
    private Type type;
    private String description;

    public Datum() {
    }

    private Datum(Parcel in) {
        id = in.readLong();
        description = in.readString();
        type = Type.valueOf(in.readString());
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(description);
        dest.writeString(type.name());
    }

    public long getId() {
        return id;
    }

    public Datum setId(long id) {
        this.id = id;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Datum setType(Type type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Datum setDescription(String description) {
        this.description = description;
        return this;
    }

    public enum Type {
        PHYSICAL, ONLINE, UNIQUEID, PURCHASE,
        FINANCIAL, COMPUTER, NAVIGATION, INTERACTIVE,
        DEMOGRAPHIC, CONTENT, STATE, POLITICAL,
        HEALTH, PREFERENCE, LOCATION, GOVERNMENT, OTHER_CATEGORY
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Datum datum = (Datum) o;

        if (id != datum.id) return false;
        if (type != datum.type) return false;
        return description != null ? description.equals(datum.description) : datum.description == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

}
