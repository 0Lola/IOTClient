package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public class Remedy implements Parcelable {

    private long id;
    private Type type;

    public Remedy() {
    }

    private Remedy(Parcel in) {
        id = in.readLong();
        type = Type.valueOf(in.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(type.name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Remedy> CREATOR = new Creator<Remedy>() {
        @Override
        public Remedy createFromParcel(Parcel in) {
            return new Remedy(in);
        }

        @Override
        public Remedy[] newArray(int size) {
            return new Remedy[size];
        }
    };

    public long getId() {
        return id;
    }

    public Remedy setId(long id) {
        this.id = id;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Remedy setType(Type type) {
        this.type = type;
        return this;
    }

    public enum Type {
        CORRECT, MONEY, LAW
    }

}
