package com.example.zxa01.iotclient.home.device.view.create;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.FragmentDeviceCreateBinding;
import com.example.zxa01.iotclient.home.device.viewModel.DeviceViewModel;

public class DeviceCreateFragment extends DialogFragment {

    private static final String QRCODE_MARKET = "market://details?id=com.google.zxing.client.android";
    private static final String QRCODE_INTENT = "com.google.zxing.client.android.SCAN";
    private static final String QRCODE_MODE = "SCAN_MODE";
    private static final String QRCODE_CODE_MODE = "QR_CODE_MODE";
    private static final int QRCODE_REQUEST_CODE = 0;

    private DeviceViewModel viewModel;

    private FragmentDeviceCreateBinding binding;


    public DeviceCreateFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setView(R.layout.fragment_device_create)
                .setNeutralButton(R.string.button_qrcode,
                        (dialog, whichButton) -> qrcodeIntent()
                )
                .setPositiveButton(R.string.button_correct,
                        (dialog, whichButton) -> viewModel.createDevice("address")
                )
                .setNegativeButton(R.string.button_cancel, (dialog, whichButton) -> {
                })
                .create();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_device_create, container, false);
        viewModel = new DeviceViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }


    private void qrcodeIntent() {
        try {
            startActivityForResult(
                    new Intent(QRCODE_INTENT)
                            .putExtra(QRCODE_MODE, QRCODE_CODE_MODE)
                    , QRCODE_REQUEST_CODE);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(QRCODE_MARKET)));
        }
    }

}
