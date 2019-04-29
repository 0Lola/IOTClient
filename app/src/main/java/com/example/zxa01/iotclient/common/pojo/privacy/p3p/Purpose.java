package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public class Purpose implements Parcelable {

    private long id;
    private Type type;
    private String description;

    public Purpose() {
    }

    protected Purpose(Parcel in) {
        id = in.readLong();
        description = in.readString();
        type = Type.valueOf(in.readString());
    }

    public static final Creator<Purpose> CREATOR = new Creator<Purpose>() {
        @Override
        public Purpose createFromParcel(Parcel in) {
            return new Purpose(in);
        }

        @Override
        public Purpose[] newArray(int size) {
            return new Purpose[size];
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

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public Purpose setType(Type type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Purpose setDescription(String description) {
        this.description = description;
        return this;
    }

    public enum Type {
        CURRENT, ADMIN, DEVELOP, TAILORING,
        PSEUDO_ANALYSIS, PSEUDO_DECISION, INDIVIDUAL_ANALYSIS, INDIVIDUAL_DECISION,
        CONTACT, HISTORICAL, TELEMARKETING, OTHER_PURPOSE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purpose purpose = (Purpose) o;

        if (id != purpose.id) return false;
        if (type != purpose.type) return false;
        return description != null ? description.equals(purpose.description) : purpose.description == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

}
