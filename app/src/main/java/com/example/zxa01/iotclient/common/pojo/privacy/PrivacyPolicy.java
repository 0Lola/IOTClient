package com.example.zxa01.iotclient.common.pojo.privacy;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedList;
import java.util.List;

public class PrivacyPolicy implements Parcelable {

    private String id;
    private String description;
    private Collector collector;
    private Dispute dispute;
    private Access access;
    private List<Remedy> remedies = new LinkedList<>();
    private List<Statement> statements = new LinkedList<>();

    public PrivacyPolicy() {
    }

    private PrivacyPolicy(Parcel in) {
        id = in.readString();
        description = in.readString();
        collector = in.readParcelable(Collector.class.getClassLoader());
        dispute = in.readParcelable(Dispute.class.getClassLoader());
        access = in.readParcelable(Access.class.getClassLoader());
        remedies = in.createTypedArrayList(Remedy.CREATOR);
        statements = in.createTypedArrayList(Statement.CREATOR);
    }

    public static final Creator<PrivacyPolicy> CREATOR = new Creator<PrivacyPolicy>() {
        @Override
        public PrivacyPolicy createFromParcel(Parcel in) {
            return new PrivacyPolicy(in);
        }

        @Override
        public PrivacyPolicy[] newArray(int size) {
            return new PrivacyPolicy[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(description);
        dest.writeParcelable(collector, flags);
        dest.writeParcelable(dispute, flags);
        dest.writeParcelable(access, flags);
        dest.writeTypedList(remedies);
        dest.writeTypedList(statements);
    }

    public String getId() {
        return id;
    }

    public PrivacyPolicy setId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PrivacyPolicy setDescription(String description) {
        this.description = description;
        return this;
    }

    public Collector getCollector() {
        return collector;
    }

    public PrivacyPolicy setCollector(Collector collector) {
        this.collector = collector;
        return this;
    }

    public Dispute getDispute() {
        return dispute;
    }

    public PrivacyPolicy setDispute(Dispute dispute) {
        this.dispute = dispute;
        return this;
    }

    public Access getAccess() {
        return access;
    }

    public PrivacyPolicy setAccess(Access access) {
        this.access = access;
        return this;
    }

    public List<Remedy> getRemedies() {
        return remedies;
    }

    public PrivacyPolicy setRemedies(List<Remedy> remedies) {
        this.remedies = remedies;
        return this;
    }

    public PrivacyPolicy addRemedy(Remedy remedy) {
        if (null != this.remedies) this.remedies.add(remedy);
        return this;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public PrivacyPolicy setStatements(List<Statement> statements) {
        this.statements = statements;
        return this;
    }

    public PrivacyPolicy addStatement(Statement statement) {
        if (null != this.statements) this.statements.add(statement);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivacyPolicy that = (PrivacyPolicy) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PrivacyPolicy{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", collector=" + collector +
                ", dispute=" + dispute +
                ", access=" + access +
                ", remedies=" + remedies +
                ", statements=" + statements +
                '}';
    }
}
