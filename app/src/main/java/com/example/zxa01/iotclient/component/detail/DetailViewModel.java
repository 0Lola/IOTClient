package com.example.zxa01.iotclient.component.detail;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.component.privacy.PrivacyActivity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.Toast;

public class DetailViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableField<Device> device = new ObservableField<>();
    private DetailModel detailModel = new DetailModel();
    private Context context;

    public DetailViewModel(Context context) {
        this.context = context;
        device.set(new Device());
    }

    public void fetchDevice(@NonNull String udn) {
        detailModel.readDevice(udn);
    }

    public MutableLiveData<Device> observeDeviceMLD() {
        return detailModel.getDeviceMLD();
    }

    public void setDevice(@NonNull Device device) {
        if (device.getUdn() != null) {
            isLoading.set(false);
            this.device.set(device);
        }
    }

    public void settingPrivacy() {
        context.startActivity(
                new Intent(context, PrivacyActivity.class)
                        .putExtra("udn", device.get().getUdn()));
    }

    public void downloadPrivacyReport() {
        // TODO download
        Toast toast = Toast.makeText(context, R.string.detail_report_download, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 15);
        toast.show();
    }
}
