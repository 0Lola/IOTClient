package com.example.zxa01.iotclient.pojo;

public class Device {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
