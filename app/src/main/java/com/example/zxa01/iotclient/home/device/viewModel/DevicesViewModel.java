package com.example.zxa01.iotclient.home.device.viewModel;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.home.device.model.DeviceModel;
import com.example.zxa01.iotclient.home.device.view.DeviceAdapter;
import com.example.zxa01.iotclient.home.device.model.DevicesModel;
import com.example.zxa01.iotclient.pojo.Device;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class DevicesViewModel extends ViewModel {

    public ObservableList<Device> mDevices = new ObservableArrayList<>();
    public ObservableBoolean isLoading = new ObservableBoolean(false);
    private DevicesModel devicesModel = new DevicesModel();
    private DeviceAdapter adapter = new DeviceAdapter(R.layout.recycler_view_device, this);

    /**
     * model
     */

    public void refreshDevices() {
        devicesModel.fetchDevices();
    }

    public MutableLiveData<List<DeviceModel>> getDevices() {
        return devicesModel.getDevices();
    }

    public void createDevice(String address) {
        devicesModel.createDevice(address);
        this.refreshDevices();
    }

    /**
     * child model
     */

    public DeviceModel getDeviceAt(Integer index) {
        if (devicesModel.getDevices().getValue() != null &&
                index != null &&
                devicesModel.getDevices().getValue().size() > index) {
            return devicesModel.getDevices().getValue().get(index);
        }
        return null;
    }

    /**
     * adapter
     */

    public DeviceAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<DeviceModel> deviceList) {
        this.adapter.setDevices(deviceList);
        this.adapter.notifyDataSetChanged();
    }

}
