package com.example.zxa01.iotclient.common.pojo.auth;
import android.support.annotation.NonNull;

public class LoginMessage {

    private String gateway;
    private String account;
    private String password;

    public LoginMessage(){

    }

    public LoginMessage(@NonNull String gateway, @NonNull String account, @NonNull String password) {
        this.gateway = gateway;
        this.account = account;
        this.password = password;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
