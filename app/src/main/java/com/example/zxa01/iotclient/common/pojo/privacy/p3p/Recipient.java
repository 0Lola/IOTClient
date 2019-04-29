package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipient implements Parcelable {

    private long id;
    private String entity;
    private Type type;

    public Recipient() {
    }

    private Recipient(Parcel in) {
        id = in.readLong();
        entity = in.readString();
        type = Type.valueOf(in.readString());
    }

    public static final Creator<Recipient> CREATOR = new Creator<Recipient>() {
        @Override
        public Recipient createFromParcel(Parcel in) {
            return new Recipient(in);
        }

        @Override
        public Recipient[] newArray(int size) {
            return new Recipient[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(entity);
        dest.writeString(type.name());
    }

    public long getId() {
        return id;
    }

    public Recipient setId(long id) {
        this.id = id;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Recipient setType(Type type) {
        this.type = type;
        return this;
    }

    public String getEntity() {
        return entity;
    }

    public Recipient setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public enum Type {
        OURS, DELIVERY, SAME, UNRELATED, PUBLIC, OTHER_RECIPIENT
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipient recipient = (Recipient) o;

        if (id != recipient.id) return false;
        if (type != recipient.type) return false;
        return entity != null ? entity.equals(recipient.entity) : recipient.entity == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (entity != null ? entity.hashCode() : 0);
        return result;
    }
}
