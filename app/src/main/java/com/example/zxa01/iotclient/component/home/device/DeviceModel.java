package com.example.zxa01.iotclient.component.home.device;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.device.Device;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceModel extends BaseObservable {

    private MutableLiveData<List<Device>> devicesMLD = new MutableLiveData<>();

    public DeviceModel() {
    }

    public MutableLiveData<List<Device>> getDevicesMLD() {
        return devicesMLD;
    }

    public void readDevices() {
        Api.getApi().readDevices().enqueue(
                new Callback<List<Device>>() {
                    @Override
                    public void onResponse(Call<List<Device>> call, @NonNull Response<List<Device>> response) {
                        devicesMLD.setValue(response.body() == null ?
                                null : response.body().stream().collect(Collectors.toList()));
                    }

                    @Override
                    public void onFailure(Call<List<Device>> call, Throwable t) {
                        Log.e("readDevices - onFailure()", t.getMessage(), t);
                    }
                }
        );
    }


}
