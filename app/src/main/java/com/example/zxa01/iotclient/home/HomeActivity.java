package com.example.zxa01.iotclient.home;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.ActivityHomeBinding;
import com.example.zxa01.iotclient.home.device.view.DeviceFragment;
import com.example.zxa01.iotclient.home.device.viewModel.DevicesViewModel;
import com.example.zxa01.iotclient.home.privacy.PrivacyFragment;
import com.example.zxa01.iotclient.home.setting.SettingFragment;

public class HomeActivity extends AppCompatActivity implements
        DeviceFragment.OnFragmentInteractionListener,
        PrivacyFragment.OnFragmentInteractionListener,
        SettingFragment.OnFragmentInteractionListener {

    /* data binding */
    private ActivityHomeBinding binding;

    /* fragments of HomeActivity */
    private DeviceFragment mDeviceFragment = new DeviceFragment();
    private PrivacyFragment mPrivacyFragment = new PrivacyFragment();
    private SettingFragment mSettingFragment = new SettingFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home);

        /* init */
        setupFragment(binding.navigation);
        showFragment(mDeviceFragment);
    }

    @Override
    public void onDeviceFragment(Uri uri) {
    }

    @Override
    public void onPrivacyFragment(Uri uri) {
    }

    @Override
    public void onSettingFragment(Uri uri) {
    }

    /* onItemSelected of fragment */
    private void setupFragment(BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            showFragment(mDeviceFragment);
                            return true;
                        case R.id.navigation_privacy:
                            showFragment(mPrivacyFragment);
                            return true;
                        case R.id.navigation_setting:
                            showFragment(mSettingFragment);
                            return true;
                    }
                    return false;
                }
        );
    }

    /* show of fragment */
    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_fragment_layout, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                new DevicesViewModel().createDevice(intent.getStringExtra("SCAN_RESULT"));
            }
        }
    }
}
