package com.example.zxa01.iotclient.common.shared;

import com.example.zxa01.iotclient.common.pojo.auth.LoginMessage;

public class DefaultData {

    private static DefaultData defaultData = new DefaultData();
    private LoginMessage loginMessage;

    private DefaultData() {
        loginMessage = new LoginMessage("192.168.2.90:8080", "user", "1234");
    }

    public static DefaultData getDefaultData() {
        return defaultData;
    }

    public LoginMessage getLoginMessage() {
        return loginMessage;
    }
}
