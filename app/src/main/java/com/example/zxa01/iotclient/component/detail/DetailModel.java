package com.example.zxa01.iotclient.component.detail;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.device.Manufacturer;
import com.example.zxa01.iotclient.common.pojo.device.Model;

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

    public void setDeviceMLD(Device device) {
        deviceMLD.setValue(device);
    }

    public void readDevice(String udn) {
        // TODO instead of udn
        Api.getApi().readDevice("1").enqueue(new Callback<Device>() {
            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                setDeviceMLD(response == null || response.body() == null ?
                        null : response.body());
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                Log.e("fetchDevice - onFailure()", t.getMessage(), t);
            }
        });

    }

}
