package com.example.zxa01.iotclient.component.home.device;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.component.detail.DetailActivity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import java.util.List;

public class DeviceViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    private DeviceModel deviceModel = new DeviceModel();
    private DeviceAdapter adapter = new DeviceAdapter(R.layout.recycler_view_device, this);
    private Context context;

    public DeviceViewModel(Context context) {
        this.context = context;
    }

    /**
     * model
     */

    public void readDevices() {
        deviceModel.readDevices();
    }

    public MutableLiveData<List<Device>> observeDevicesMLD() {
        return deviceModel.getDevicesMLD();
    }

    /**
     * child model
     */

    public Device getDeviceAt(@NonNull Integer index) {
        if (deviceModel.getDevicesMLD().getValue() != null &&
                deviceModel.getDevicesMLD().getValue().size() > index) {
            return deviceModel.getDevicesMLD().getValue().get(index);
        }
        return null;
    }

    public void onDevicesClick(@NonNull Integer index) {
        if (deviceModel.getDevicesMLD().getValue() != null &&
                deviceModel.getDevicesMLD().getValue().size() > index) {
            context.startActivity(
                    new Intent(context, DetailActivity.class)
                            .putExtra("udn", deviceModel.getDevicesMLD().getValue().get(index).getUdn()));
        }
    }

    /**
     * adapter
     */

    public DeviceAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<Device> devices) {
        isLoading.set(false);
        adapter.setDevices(devices);
    }

}
