package com.example.zxa01.iotclient.component.login;

import com.example.zxa01.iotclient.component.home.HomeActivity;
import com.example.zxa01.iotclient.component.login.pojo.LoginMessage;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

public class LoginViewModel extends ViewModel {

    public ObservableField<LoginMessage> loginMessage = new ObservableField<>();
    private Context context;
    private LoginModel loginModel = new LoginModel();

    public LoginViewModel(Context context) {
        this.context = context;
        loginMessage.set(new LoginMessage("192.168.2.69:8081","user","1234"));
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
