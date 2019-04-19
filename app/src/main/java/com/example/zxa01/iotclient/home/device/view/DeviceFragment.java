package com.example.zxa01.iotclient.home.device.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.FragmentDeviceBinding;
import com.example.zxa01.iotclient.home.device.viewModel.DevicesViewModel;
import com.example.zxa01.iotclient.home.device.view.create.DeviceCreateFragment;

public class DeviceFragment extends Fragment {

    private FragmentDeviceBinding binding;
    private DevicesViewModel viewModel = new DevicesViewModel();

    public DeviceFragment() {
    }

    public static DeviceFragment newInstance() {
        return new DeviceFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_device, container, false);
        binding.setViewModel(viewModel);
        setup();
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setup() {
        binding.fab.setOnClickListener(item -> drawDialog());
        binding.deviceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel.refreshDevices();
        viewModel.getDevices().observe(this, deviceList -> viewModel.setAdapter(deviceList));
    }

    private void drawDialog() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag(String.valueOf(R.string.dialog));
        if (fragment != null) {
            fragmentTransaction.remove(fragment);
        }
        fragmentTransaction.addToBackStack(null);
        new DeviceCreateFragment().show(fragmentTransaction, String.valueOf(R.string.dialog));
    }

    public interface OnFragmentInteractionListener {
        void onDeviceFragment(Uri uri);
    }

}
