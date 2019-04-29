package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

public class Dispute implements Parcelable {

    private long id;
    private String relatedOrganization;
    private Type type;

    public Dispute() {
    }

    protected Dispute(Parcel in) {
        id = in.readLong();
        relatedOrganization = in.readString();
        type = Type.valueOf(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(relatedOrganization);
        dest.writeString(type.name());
    }

    public static final Creator<Dispute> CREATOR = new Creator<Dispute>() {
        @Override
        public Dispute createFromParcel(Parcel in) {
            return new Dispute(in);
        }

        @Override
        public Dispute[] newArray(int size) {
            return new Dispute[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRelatedOrganization() {
        return relatedOrganization;
    }

    public Dispute setRelatedOrganization(String relatedOrganization) {
        this.relatedOrganization = relatedOrganization;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Dispute setType(Type type) {
        this.type = type;
        return this;
    }

    public enum Type {
        SERVICE, INDEPENDENT, COURT, LAW
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dispute dispute = (Dispute) o;

        if (id != dispute.id) return false;
        if (relatedOrganization != null ? !relatedOrganization.equals(dispute.relatedOrganization) : dispute.relatedOrganization != null)
            return false;
        return type == dispute.type;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (relatedOrganization != null ? relatedOrganization.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
