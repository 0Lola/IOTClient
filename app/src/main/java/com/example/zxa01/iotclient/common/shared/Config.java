package com.example.zxa01.iotclient.common.shared;


import com.example.zxa01.iotclient.common.pojo.Setting;
import com.example.zxa01.iotclient.common.pojo.auth.User;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Config {

    public static String USER = "使用者";
    public static String GATEWAY = "閘道器位置";
    public static String LOGOUT = "登出";
    public static String LOGOUT_MESSAGE = "登出本帳號";
    private static Config config = new Config();
    private User user;
    private String gateway;
    private List<Setting> settings;

    private Config() {
        this.reset();
    }

    public static Config getConfig() {
        return config;
    }

    public void reset() {
        this.user = new User();
        this.gateway = "";
        this.settings = new LinkedList<>();
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
