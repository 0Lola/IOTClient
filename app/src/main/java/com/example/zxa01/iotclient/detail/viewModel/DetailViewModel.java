package com.example.zxa01.iotclient.detail.viewModel;

import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.detail.model.DetailModel;
import com.example.zxa01.iotclient.privacy.view.PrivacyActivity;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

public class DetailViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableField<Device> device = new ObservableField<>();
    private DetailModel detailModel = new DetailModel();
    private Context context;

    public DetailViewModel(Context context) {
        this.device.set(new Device());
        this.context = context;
    }

    public void fetchDevice() {
        detailModel.fetchDevice();
    }

    public ObservableField<Device> getDevice() {
        isLoading.set(false);
        return detailModel.getDevice();
    }

    public void setDevice(Device device) {
        this.device.set(device);
    }

    public void settingPrivacy() {
        context.startActivity(
                new Intent(context, PrivacyActivity.class)
                        .putExtra("udn", device.get().getUDN()));
    }

    public void downloadPrivacyReport() {
        // TODO download
    }
}
