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
//        Callback<Object> callback = new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//                // TODO login
//                isAuthorized.setValue(true);
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//                Log.e("login - onFailure()", t.getMessage(), t);
//            }
//        };
//
//        // TODO loginMessage to json
//        Api.getApi().getDevices().enqueue(callback);
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
        Config.getConfig().addSetting(new Setting(Config.USER, Config.getConfig().getUser().getAccount()));
        Config.getConfig().addSetting(new Setting(Config.GATEWAY, message.getGateway()));
        Config.getConfig().addSetting(new Setting(Config.LOGOUT, Config.LOGOUT_MESSAGE));
    }

}
