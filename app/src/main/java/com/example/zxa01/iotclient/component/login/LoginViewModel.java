package com.example.zxa01.iotclient.component.login;

import com.example.zxa01.iotclient.common.shared.DefaultData;
import com.example.zxa01.iotclient.component.home.HomeActivity;
import com.example.zxa01.iotclient.common.pojo.auth.LoginMessage;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

public class LoginViewModel extends ViewModel {

    public ObservableField<LoginMessage> loginMessage = new ObservableField<>();
    private LoginModel loginModel = new LoginModel();
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
        loginMessage.set(DefaultData.getDefaultData().getLoginMessage());
    }

    public void login() {
        loginModel.login(loginMessage.get());
    }

    public void checkAuthorized(Boolean isAuthorized) {
        if (isAuthorized) {
            context.startActivity(
                    new Intent(context, HomeActivity.class));
        }
    }

    public MutableLiveData<Boolean> isAuthorized() {
        return loginModel.isAuthorized();
    }

}
