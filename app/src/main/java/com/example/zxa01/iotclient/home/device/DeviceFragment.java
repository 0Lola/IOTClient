package com.example.zxa01.iotclient.home.device;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.FragmentDeviceBinding;

public class DeviceFragment extends Fragment {

    private FragmentDeviceBinding binding;
    private DeviceViewModel viewModel = new DeviceViewModel();

    public DeviceFragment() {
    }

    public static DeviceFragment newInstance() {
        return new DeviceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_device,container,false);
        binding.setViewModel(viewModel);
        refreshDevices(binding.deviceRecyclerView);
        setupDialog(binding.fab);
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

    public interface OnFragmentInteractionListener {
        void onDeviceFragment(Uri uri);
    }

    private void refreshDevices(RecyclerView view){
        view.setLayoutManager(new LinearLayoutManager(getActivity()));
        view.setAdapter(new DeviceAdapter(viewModel.getDevices()));
    }

    private void setupDialog(View view){
        view.setOnClickListener(item -> drawDialog());
    }

    private void drawDialog(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag(String.valueOf(R.string.dialog));
        if (fragment != null) {
            fragmentTransaction.remove(fragment);
        }
        fragmentTransaction.addToBackStack(null);
        new DeviceCreateFragment().show(fragmentTransaction, String.valueOf(R.string.dialog));
    }

}
