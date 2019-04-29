package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public enum Access implements Parcelable {
    NON_IDENT, ALL, CONTACT_AND_OTHER, IDENT_CONTACT, OTHER_IDENT, NONE;

    Access() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Access> CREATOR = new Creator<Access>() {
        @Override
        public Access createFromParcel(Parcel in) {
            return Access.valueOf(in.readString());
        }

        @Override
        public Access[] newArray(int size) {
            return new Access[size];
        }
    };
}
