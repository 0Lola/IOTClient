package com.example.zxa01.iotclient.component.home.device.bind;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

public class DeviceBindViewModel extends ViewModel {

    private static final String QRCODE_MARKET = "market://details?id=com.google.zxing.client.android";
    private static final String QRCODE_INTENT = "com.google.zxing.client.android.SCAN";
    private static final String QRCODE_MODE = "SCAN_MODE";
    private static final String QRCODE_CODE_MODE = "QR_CODE_MODE";
    private static final int QRCODE_REQUEST_CODE = 0;

    public ObservableField<String> udn = new ObservableField<>();
    private DeviceBindModel deviceBindModel = new DeviceBindModel();
    private Fragment fragment;

    public DeviceBindViewModel() {
    }

    public DeviceBindViewModel(Fragment fragment) {
        this.fragment = fragment;
    }

    /**
     * button function
     */

    public void bindDeviceAndGateway(String udn) {
        deviceBindModel.bindDeviceAndGateway(udn);
    }

    public void bindDeviceAndGateway() {
        deviceBindModel.bindDeviceAndGateway(udn.get());
    }

    public void qrcode() {
        try {
            fragment.startActivityForResult(
                    new Intent(QRCODE_INTENT)
                            .putExtra(QRCODE_MODE, QRCODE_CODE_MODE)
                    , QRCODE_REQUEST_CODE);
        } catch (Exception e) {
            fragment.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(QRCODE_MARKET)));
        }
    }

    public void cancel() {
        ((DeviceBindFragment) fragment).dismiss();
    }


}
