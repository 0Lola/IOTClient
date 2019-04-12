package com.example.zxa01.iotclient.home.device;
import android.arch.lifecycle.ViewModel;

import com.example.zxa01.iotclient.home.service.CommonService;
import com.example.zxa01.iotclient.pojo.Device;
import java.util.LinkedList;

public class DeviceViewModel extends ViewModel {

    private LinkedList<Device> mList = new LinkedList<>();
    private CommonService service;

    public DeviceViewModel(){
        updateDevices();
    }

    public void updateDevices(){
        // TODO api service.queryDevices();
        Device device1 = new Device(1, "test1", "test", "test", true);
        Device device2 = new Device(1, "test2", "test", "test", true);
        Device device3 = new Device(1, "test3", "test", "test", true);
        mList.add(device1);
        mList.add(device2);
        mList.add(device3);
    }

    public LinkedList<Device> getDevices() {
        return mList;
    }

    public void createDevice(String address){
        // TODO query and update mList
        // service.createDevice(address);
    }

}
