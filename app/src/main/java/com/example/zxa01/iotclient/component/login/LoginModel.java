package com.example.zxa01.iotclient.component.login;
import com.example.zxa01.iotclient.common.pojo.Setting;
import com.example.zxa01.iotclient.common.pojo.auth.User;
import com.example.zxa01.iotclient.common.shared.Config;
import com.example.zxa01.iotclient.component.login.pojo.LoginMessage;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

public class LoginModel extends BaseObservable {

    private MutableLiveData<Boolean> isAuthorized;
    private static String USER = "使用者";
    private static String GATEWAY = "閘道器位置";
    private static String Port = "Port";
    private static String LOGOUT = "登出";
    private static String LOGOUT_MESSAGE = "登出本帳號";


    public LoginModel() {
        isAuthorized = new MutableLiveData<>();
        isAuthorized.setValue(false);
    }

    public MutableLiveData<Boolean> isAuthorized(){
        return isAuthorized;
    }

    public void login(@NonNull LoginMessage message) {

        Config.getConfig().setUser(new User().setAccount(message.getAccount()));
        Config.getConfig().setGateway(message.getGateway());
        Config.getConfig().addSetting(new Setting(USER,Config.getConfig().getUser().getAccount()));
        Config.getConfig().addSetting(new Setting(GATEWAY,message.getGateway()));
        Config.getConfig().addSetting(new Setting(Port,message.getGateway()));
        Config.getConfig().addSetting(new Setting(LOGOUT,LOGOUT_MESSAGE));

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
