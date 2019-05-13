package com.example.zxa01.iotclient.component.detail;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailModel extends BaseObservable {

    private MutableLiveData<Device> deviceMLD = new MutableLiveData<>();

    public DetailModel() {
    }

    public MutableLiveData<Device> getDeviceMLD() {
        return deviceMLD;
    }

    public void setDeviceMLD(@NonNull Device device) {
        deviceMLD.setValue(device);
    }

    public void readDevice(@NonNull String udn) {
        Api.getApi().readDevice(udn).enqueue(new Callback<Device>() {
            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                setDeviceMLD(response == null || response.body() == null ?
                        null : response.body());
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                Log.e("readDevice - onFailure()", t.getMessage(), t);
            }
        });

    }

}
