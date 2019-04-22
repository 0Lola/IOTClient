package com.example.zxa01.iotclient.login.viewModel;

import com.example.zxa01.iotclient.home.HomeActivity;
import com.example.zxa01.iotclient.login.model.LoginModel;
import com.example.zxa01.iotclient.login.pojo.LoginMessage;
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
        loginMessage.set(new LoginMessage());
        this.context = context;
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
