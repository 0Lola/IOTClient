package com.example.zxa01.iotclient.common.pojo.privacy.p3p;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedList;
import java.util.List;

public class Statement implements Parcelable {

    private long id;
    private String consequence;
    private List<Purpose> purposes = new LinkedList<>();
    private List<Datum> data = new LinkedList<>();
    private List<Recipient> recipients = new LinkedList<>();
    private Retention retention;

    public Statement() {
    }

    private Statement(Parcel in) {
        id = in.readLong();
        consequence = in.readString();
        purposes = in.createTypedArrayList(Purpose.CREATOR);
        data = in.createTypedArrayList(Datum.CREATOR);
        recipients = in.createTypedArrayList(Recipient.CREATOR);
        retention = in.readParcelable(Retention.class.getClassLoader());
    }

    public static final Creator<Statement> CREATOR = new Creator<Statement>() {
        @Override
        public Statement createFromParcel(Parcel in) {
            return new Statement(in);
        }

        @Override
        public Statement[] newArray(int size) {
            return new Statement[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(consequence);
        dest.writeTypedList(purposes);
        dest.writeTypedList(data);
        dest.writeTypedList(recipients);
        dest.writeParcelable(retention, flags);
    }

    public long getId() {
        return id;
    }

    public Statement setId(long id) {
        this.id = id;
        return this;
    }

    public String getConsequence() {
        return consequence;
    }

    public Statement setConsequence(String consequence) {
        this.consequence = consequence;
        return this;
    }

    public List<Purpose> getPurposes() {
        return purposes;
    }

    public Statement setPurposes(List<Purpose> purposes) {
        this.purposes = purposes;
        return this;
    }

    public Statement addPurpose(Purpose purpose) {
        if (null != this.purposes) this.purposes.add(purpose);
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public Statement setData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public Statement addDatum(Datum datum) {
        if (null != this.data) this.data.add(datum);
        return this;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public Statement setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
        return this;
    }

    public Statement addRecipient(Recipient recipient) {
        if (null != this.recipients) this.recipients.add(recipient);
        return this;
    }

    public Retention getRetention() {
        return retention;
    }

    public Statement setRetention(Retention retention) {
        this.retention = retention;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        if (consequence != null ? !consequence.equals(statement.consequence) : statement.consequence != null)
            return false;
        if (purposes != null ? !purposes.equals(statement.purposes) : statement.purposes != null) return false;
        if (data != null ? !data.equals(statement.data) : statement.data != null) return false;
        if (recipients != null ? !recipients.equals(statement.recipients) : statement.recipients != null) return false;
        return retention == statement.retention;
    }

    @Override
    public int hashCode() {
        int result = consequence != null ? consequence.hashCode() : 0;
        result = 31 * result + (purposes != null ? purposes.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (recipients != null ? recipients.hashCode() : 0);
        result = 31 * result + (retention != null ? retention.hashCode() : 0);
        return result;
    }

}
