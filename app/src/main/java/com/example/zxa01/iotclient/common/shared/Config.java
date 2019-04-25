package com.example.zxa01.iotclient.common.shared;


import com.example.zxa01.iotclient.common.pojo.Setting;
import com.example.zxa01.iotclient.common.pojo.auth.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Config {

    private static Config config = new Config();

    private User user;
    private String gateway;
    private List<Setting> settings;

    private Config() {
        this.user = new User();
        this.gateway = "";
        this.settings = new LinkedList<>();
    }

    public static Config getConfig() {
        return config;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void addSetting(Setting setting) {
        this.settings = this.settings.stream()
                .filter((item) -> !item.getKey().equals(setting.getKey()))
                .collect(Collectors.toList());
        this.settings.add(setting);
    }


}
