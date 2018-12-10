package com.example.zxa01.iotclient.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.device.DeviceFragment;
import com.example.zxa01.iotclient.privacy.PrivacyFragment;
import com.example.zxa01.iotclient.setting.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity
        implements HomeFragment.OnFragmentInteractionListener, DeviceFragment.OnFragmentInteractionListener
        , PrivacyFragment.OnFragmentInteractionListener, SettingFragment.OnFragmentInteractionListener {

    DeviceFragment mDeviceFragment = new DeviceFragment();
    PrivacyFragment mPrivacyFragment = new PrivacyFragment();
    SettingFragment mSettingFragment = new SettingFragment();

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
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
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(mDeviceFragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // do nothing
    }

    @Override
    public void onDeviceFragment(Uri uri) {
        // do nothing
    }

    @Override
    public void onPrivacyFragment(Uri uri) {
        // do nothing
    }

    @Override
    public void onSettingFragment(Uri uri) {
        // do nothing
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_home, fragment)
                .commit();
    }
}
