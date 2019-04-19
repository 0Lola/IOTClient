package com.example.zxa01.iotclient.home.device.model;
import com.example.zxa01.iotclient.pojo.Device;
import android.databinding.BaseObservable;

public class DeviceModel extends BaseObservable {

    private Device device;

    public DeviceModel(Device device){
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}

