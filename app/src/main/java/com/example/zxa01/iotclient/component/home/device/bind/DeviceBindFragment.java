package com.example.zxa01.iotclient.component.home.device.bind;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.FragmentDeviceBindBinding;

public class DeviceBindFragment extends DialogFragment {

    private DeviceBindViewModel viewModel;
    private FragmentDeviceBindBinding binding;

    public DeviceBindFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_device_bind, container, false);
        binding();
        return binding.getRoot();
    }


    private void binding() {
        viewModel = new DeviceBindViewModel(this);
        binding.setViewModel(viewModel);
    }


}
