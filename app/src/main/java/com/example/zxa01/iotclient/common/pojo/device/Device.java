package com.example.zxa01.iotclient.common.pojo.device;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

import java.util.LinkedList;
import java.util.List;

public class Device implements Parcelable {

    private String udn;
    private String name;
    private Type type;
    private Manufacturer manufacturer;
    private Model model;
    private String UPC;
    private String location;
    private List<Icon> icons = new LinkedList<>();
    private Status status;

    public enum Status {
        Connected, Connecting, Disconnected, Disconnecting
    }

    public Device() {
    }

    public Device(Device device) {
        if (device.icons != null) {
            for (Icon icon : device.icons) {
                icons.add(new Icon(icon));
            }
        }
        this.setUdn(device.udn)
                .setName(device.name)
                .setType(device.type)
                .setManufacturer(device.manufacturer != null ? new Manufacturer(device.manufacturer) : null)
                .setModel(device.model != null ? new Model(device.model) : null)
                .setUPC(device.UPC)
                .setLocation(device.location)
                .setStatus(device.status);
    }

    private Device(Parcel in) {
        udn = in.readString();
        name = in.readString();
        type = Type.valueOf(in.readString());
        manufacturer = in.readParcelable(Manufacturer.class.getClassLoader());
        model = in.readParcelable(Model.class.getClassLoader());
        UPC = in.readString();
        location = in.readString();
        icons = in.createTypedArrayList(Icon.CREATOR);
        status = Status.valueOf(in.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(udn);
        dest.writeString(name);
        dest.writeString(type.name());
        dest.writeParcelable(manufacturer, flags);
        dest.writeParcelable(model, flags);
        dest.writeString(UPC);
        dest.writeString(location);
        dest.writeTypedList(icons);
        dest.writeString(status.name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel in) {
            return new Device(in);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };

    public String getUdn() {
        return udn;
    }

    public Device setUdn(String udn) {
        this.udn = udn;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Device setType(Type type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Device setName(String name) {
        this.name = name;
        return this;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Device setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public Device setModel(Model model) {
        this.model = model;
        return this;
    }

    public String getUPC() {
        return UPC;
    }

    public Device setUPC(String UPC) {
        this.UPC = UPC;
        return this;
    }

    public List<Icon> getIcons() {
        return icons;
    }

    public Device setIcons(List<Icon> icons) {
        this.icons = icons;
        return this;
    }

    public Device addIcon(Icon icon) {
        if (null != this.icons) this.icons.add(icon);
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Device setLocation(String location) {
        this.location = location;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Device setStatus(Status status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        return udn != null ? udn.equals(device.udn) : device.udn == null;
    }

    @Override
    public int hashCode() {
        return udn != null ? udn.hashCode() : 0;
    }

    public enum Type {
        Sensor, Actuator, Mixed, Other
    }

    @Override
    public String toString() {
        return "Device{" +
                "udn='" + udn + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", manufacturer=" + manufacturer +
                ", model=" + model +
                ", UPC='" + UPC + '\'' +
                ", location='" + location + '\'' +
                ", icons=" + icons +
                ", status=" + status +
                '}';
    }

}
