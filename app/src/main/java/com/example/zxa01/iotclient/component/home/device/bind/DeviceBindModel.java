package com.example.zxa01.iotclient.component.home.device.bind;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.device.Device;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceBindModel extends BaseObservable {

    public DeviceBindModel() {
    }


    public void bindDeviceAndGateway(@NonNull String udn) {
        Api.getApi().bindDeviceAndGateway(udn).enqueue(
                new Callback<Device>() {
                    @Override
                    public void onResponse(Call<Device> call, Response<Device> response) {
                    }

                    @Override
                    public void onFailure(Call<Device> call, Throwable t) {
                        Log.e("bindDeviceAndGateway - onFailure()", t.getMessage(), t);
                    }
                }
        );
    }
}
