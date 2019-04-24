package com.example.zxa01.iotclient.home.setting.model;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;

import com.example.zxa01.iotclient.common.pojo.Setting;
import java.util.ArrayList;
import java.util.List;

public class SettingModel extends BaseObservable {

    private List<Setting> settings = new ArrayList<>();
    private MutableLiveData<List<Setting>> settingsMLD = new MutableLiveData<>();

    public SettingModel(){

    }

    private void addSettings(Setting setting) {
        settings.add(setting);
    }

    public MutableLiveData<List<Setting>> getSettingMLD() {
        return settingsMLD;
    }


    public void fetchSetting(){
        // getSetting
        addSettings(new Setting("Gateway address", "192.168.2.69"));
        addSettings(new Setting("Account", "Test"));
        addSettings(new Setting("HTTP port", "8080"));
        addSettings(new Setting("WebSocket port", "8081"));
        addSettings(new Setting("Log out", "exchange account"));
        settingsMLD.setValue(settings);
    }
}
