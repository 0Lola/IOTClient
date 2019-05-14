package com.example.zxa01.iotclient.component.login;
import com.example.zxa01.iotclient.common.pojo.Setting;
import com.example.zxa01.iotclient.common.pojo.auth.User;
import com.example.zxa01.iotclient.common.shared.Config;
import com.example.zxa01.iotclient.common.pojo.auth.LoginMessage;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

public class LoginModel extends BaseObservable {

    private MutableLiveData<Boolean> isAuthorized;

    public LoginModel() {
        isAuthorized = new MutableLiveData<>();
        isAuthorized.setValue(false);
    }

    public MutableLiveData<Boolean> isAuthorized() {
        return isAuthorized;
    }

    public void login(@NonNull LoginMessage message) {

        if (verification(message)) {
            settingConfig(message);
            isAuthorized.setValue(true);
        }

    }

    private boolean verification(@NonNull LoginMessage message) {
        return message.getAccount() != null &&
                message.getPassword() != null &&
                message.getGateway() != null;

    }

    private void settingConfig(@NonNull LoginMessage message) {
        Config.getConfig().setUser(new User().setAccount(message.getAccount()));
        Config.getConfig().setGateway(message.getGateway());
        Config.getConfig().addSetting(new Setting().setKey(Config.USER).setValue(Config.getConfig().getUser().getAccount()));
        Config.getConfig().addSetting(new Setting().setKey(Config.GATEWAY).setValue(message.getGateway()));
        Config.getConfig().addSetting(new Setting().setKey(Config.LOGOUT).setValue(Config.LOGOUT_MESSAGE));
    }

}
