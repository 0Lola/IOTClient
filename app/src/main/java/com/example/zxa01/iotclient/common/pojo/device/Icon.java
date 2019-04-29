package com.example.zxa01.iotclient.common.pojo.device;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Icon implements Parcelable {

    private byte[] bytes;

    public Icon() {
    }

    public Icon(Icon icon) {
        this.setBytes(icon.bytes);
    }

    private Icon(Parcel in) {
        bytes = in.createByteArray();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(bytes);
    }

    public static final Creator<Icon> CREATOR = new Creator<Icon>() {
        @Override
        public Icon createFromParcel(Parcel in) {
            return new Icon(in);
        }

        @Override
        public Icon[] newArray(int size) {
            return new Icon[size];
        }
    };

    public byte[] getBytes() {
        return bytes;
    }

    public Icon setBytes(byte[] bytes) {
        this.bytes = bytes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Icon icon = (Icon) o;

        return Arrays.equals(bytes, icon.bytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

}
