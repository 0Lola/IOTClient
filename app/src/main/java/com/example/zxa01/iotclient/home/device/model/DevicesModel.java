package com.example.zxa01.iotclient.home.device.model;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.util.Log;

import com.example.zxa01.iotclient.http.Api;
import com.example.zxa01.iotclient.pojo.Device;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DevicesModel extends BaseObservable {

    private String status;
    private List<DeviceModel> deviceList = new ArrayList<>();
    private MutableLiveData<List<DeviceModel>> devices = new MutableLiveData<>();

    public void addDevice(DeviceModel device) {
        deviceList.add(device);
    }

    public MutableLiveData<List<DeviceModel>> getDevices() {
        return devices;
    }

    public void fetchDevices() {
        Callback<Object> callback = new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                // TODO transfer response
                Log.i("Test", response.message());
                DevicesModel devicesModel = new DevicesModel();
                    devicesModel.addDevice(new DeviceModel(
                            new Device(1, "test", "test", "test", true)));
                devices.setValue(devicesModel.deviceList);
                status = "success";
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("Test", t.getMessage(), t);

            }
        };

        Api.getApi().getDevices().enqueue(callback);

    }

    public void createDevice(String address) {
        // TODO api post-createDevice & update
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String statue) {
        this.status = statue;
    }
}
