package com.example.zxa01.iotclient.component.home;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.component.home.device.DeviceViewModel;
import com.example.zxa01.iotclient.databinding.ActivityHomeBinding;
import com.example.zxa01.iotclient.component.home.device.DeviceFragment;
import com.example.zxa01.iotclient.component.home.record.RecordFragment;
import com.example.zxa01.iotclient.component.home.setting.SettingFragment;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private HomeViewModel viewModel;

    private DeviceFragment mDeviceFragment = new DeviceFragment();
    private RecordFragment mRecordFragment = new RecordFragment();
    private SettingFragment mSettingFragment = new SettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding();
        init();
    }

    private void binding() {
        viewModel = new HomeViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
    }

    private void init() {
        setupFragment(binding.navigation);
        showFragment(mDeviceFragment);
    }

    private void setupFragment(BottomNavigationView view) {
        view.setOnNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            showFragment(mDeviceFragment);
                            return true;
                        case R.id.navigation_privacy:
                            showFragment(mRecordFragment);
                            return true;
                        case R.id.navigation_setting:
                            showFragment(mSettingFragment);
                            return true;
                    }
                    return false;
                }
        );
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.homeFragmentLayout.getId(), fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {
            new DeviceViewModel().createDevice(intent.getStringExtra("SCAN_RESULT"));
        } else {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.create_qrcode_error)
                    .show();
        }
    }

}
