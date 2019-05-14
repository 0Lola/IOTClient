package com.example.zxa01.iotclient.common.pojo;


public class Setting {
    private String key;
    private String value;

    public Setting() {
    }

    public String getKey() {
        return key;
    }

    public Setting setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Setting setValue(String value) {
        this.value = value;
        return this;
    }
}
