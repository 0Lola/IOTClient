package com.example.zxa01.iotclient.component.home.setting;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.Setting;
import com.example.zxa01.iotclient.common.shared.Config;
import com.example.zxa01.iotclient.component.login.LoginActivity;

import java.util.List;

public class SettingViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    private SettingModel settingModel = new SettingModel();
    private SettingAdapter adapter = new SettingAdapter(R.layout.recycler_view_setting,this);
    private Context context;


    public SettingViewModel(Context context){
        this.context = context;
    }

    /**
     * model
     */

    public void refreshSetting(){
        settingModel.fetchSetting();
    }

    public MutableLiveData<List<Setting>> observeSettingMLD() {
        return settingModel.getSettingMLD();
    }


    /**
     * child model
     */

    public Setting getSettingAt(Integer index) {
        if (settingModel.getSettingMLD().getValue() != null &&
                index != null &&
                settingModel.getSettingMLD().getValue().size() > index) {
            return settingModel.getSettingMLD().getValue().get(index);
        }
        return null;
    }

    public void onSettingClick(Integer index) {
        if (settingModel.getSettingMLD().getValue() != null &&
                index != null &&
                settingModel.getSettingMLD().getValue().size() > index) {
            if(settingModel.getSettingMLD().getValue().get(index).getKey().equals(Config.LOGOUT)){
                Config.getConfig().reset();
                context.startActivity(
                        new Intent(context, LoginActivity.class));
            }
        }
    }

    /**
     * adapter
     */

    public SettingAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<Setting> settings) {
        isLoading.set(false);
        adapter.setSettings(settings);
    }
}
