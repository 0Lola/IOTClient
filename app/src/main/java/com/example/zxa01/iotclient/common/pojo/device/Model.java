package com.example.zxa01.iotclient.common.pojo.device;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private long id;
    private String name;
    private String url;
    private String description;

    public Model() {
    }

    public Model(Model model) {
        this.setId(model.id)
                .setName(model.name)
                .setDescription(model.description)
                .setUrl(model.url);
    }

    private Model(Parcel in) {
        id = in.readLong();
        name = in.readString();
        url = in.readString();
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(description);
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public long getId() {
        return id;
    }

    public Model setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Model setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Model setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (id != model.id) return false;
        if (name != null ? !name.equals(model.name) : model.name != null) return false;
        if (url != null ? !url.equals(model.url) : model.url != null) return false;
        return description != null ? description.equals(model.description) : model.description == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
