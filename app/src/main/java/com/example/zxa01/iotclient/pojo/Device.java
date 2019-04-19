package com.example.zxa01.iotclient.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Device extends BaseObservable {

    private int id;
    private String name;
    private String subTitle;
    private String type;
    private boolean status;

    public Device(int id, String name, String subTitle, String type, boolean status) {
        this.id = id;
        this.name = name;
        this.subTitle = subTitle;
        this.type = type;
        this.status = status;
    }

    public Device() {

    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Bindable
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
