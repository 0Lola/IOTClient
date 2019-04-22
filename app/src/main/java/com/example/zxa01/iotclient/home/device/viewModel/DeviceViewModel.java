package com.example.zxa01.iotclient.home.device.viewModel;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.detail.view.DetailActivity;
import com.example.zxa01.iotclient.home.device.view.DeviceAdapter;
import com.example.zxa01.iotclient.home.device.model.DeviceModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import java.util.List;

public class DeviceViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    private Context context;
    private DeviceModel deviceModel = new DeviceModel();
    private DeviceAdapter adapter = new DeviceAdapter(R.layout.recycler_view_device, this);


    public DeviceViewModel(Context context) {
        this.context = context;
    }

    public DeviceViewModel() {

    }


    /**
     * model
     */

    public void refreshDevices() {
        deviceModel.fetchDevices();
    }

    public MutableLiveData<List<Device>> getDevices() {
        return deviceModel.getDevices();
    }

    public void createDevice(String address) {
        deviceModel.createDevice(address);
        this.refreshDevices();
    }

    /**
     * child model
     */

    public Device getDeviceAt(Integer index) {
        if (deviceModel.getDevices().getValue() != null &&
                index != null &&
                deviceModel.getDevices().getValue().size() > index) {
            return deviceModel.getDevices().getValue().get(index);
        }
        return null;
    }

    public void onDevicesClick(Integer index) {
        if (deviceModel.getDevices().getValue() != null &&
                index != null &&
                deviceModel.getDevices().getValue().size() > index) {
            // TODO detail of device
            context.startActivity(
                    new Intent(context, DetailActivity.class)
                            .putExtra("index", index));
        }
    }

    /**
     * adapter
     */

    public DeviceAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<Device> deviceList) {
        this.isLoading.set(false);
        this.adapter.setDevices(deviceList);
        this.adapter.notifyDataSetChanged();
    }

}
