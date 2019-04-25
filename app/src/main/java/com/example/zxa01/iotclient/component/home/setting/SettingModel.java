package com.example.zxa01.iotclient.component.home.setting;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;

import com.example.zxa01.iotclient.common.pojo.Setting;
import com.example.zxa01.iotclient.common.shared.Config;

import java.util.List;

public class SettingModel extends BaseObservable {

    private MutableLiveData<List<Setting>> settingsMLD = new MutableLiveData<>();

    public SettingModel(){
    }

    public MutableLiveData<List<Setting>> getSettingMLD() {
        return settingsMLD;
    }


    public void fetchSetting(){
        settingsMLD.setValue(Config.getConfig().getSettings());
    }
}
