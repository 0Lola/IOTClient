package com.example.zxa01.iotclient.login.model;
import com.example.zxa01.iotclient.login.pojo.LoginMessage;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

public class LoginModel extends BaseObservable {

    private MutableLiveData<Boolean> isAuthorized = new MutableLiveData<>();

    public LoginModel() {
        isAuthorized.setValue(false);
    }

    public MutableLiveData<Boolean> isAuthorized(){
        return isAuthorized;
    }

    public void login(@NonNull LoginMessage message) {
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

    public void vaild() {
        //TODO 驗證帳號格式
    }


}
