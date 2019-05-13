package com.example.zxa01.iotclient.component.home.device;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.FragmentDeviceBinding;
import com.example.zxa01.iotclient.component.home.device.bind.DeviceBindFragment;


public class DeviceFragment extends Fragment {

    private DeviceViewModel viewModel;
    private FragmentDeviceBinding binding;

    public DeviceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_device, container, false);
        binding();
        init();
        return binding.getRoot();
    }

    private void binding(){
        viewModel = new DeviceViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        binding.fab.setOnClickListener(item -> drawDialog());
        binding.deviceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void init() {
        viewModel.readDevices();
        viewModel.observeDevicesMLD().observe(this, viewModel::setAdapter);
    }

    private void drawDialog() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag(String.valueOf(R.string.dialog));
        if (fragment != null) {
            fragmentTransaction.remove(fragment);
        }
        fragmentTransaction.addToBackStack(null);
        new DeviceBindFragment().show(fragmentTransaction, String.valueOf(R.string.dialog));
    }


}
