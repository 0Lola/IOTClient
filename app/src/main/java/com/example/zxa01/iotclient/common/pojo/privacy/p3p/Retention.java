package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public enum Retention implements Parcelable {
    NO_RETENTION, STATED_PURPOSE, LEGAL_REQUIREMENT, INDEFINITELY, BUSINESS_PRACTICES;

    Retention() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Retention> CREATOR = new Creator<Retention>() {
        @Override
        public Retention createFromParcel(Parcel in) {
            return Retention.valueOf(in.readString());
        }

        @Override
        public Retention[] newArray(int size) {
            return new Retention[size];
        }
    };
}
