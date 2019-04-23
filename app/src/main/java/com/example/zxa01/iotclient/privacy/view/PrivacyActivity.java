package com.example.zxa01.iotclient.privacy.view;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.ActivityPrivacyBinding;
import com.example.zxa01.iotclient.detail.viewModel.DetailViewModel;
import com.example.zxa01.iotclient.home.device.view.create.DeviceCreateFragment;
import com.example.zxa01.iotclient.privacy.viewModel.PrivacyViewModel;

public class PrivacyActivity extends AppCompatActivity {

    private ActivityPrivacyBinding binding;
    private PrivacyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_privacy);
        viewModel = new PrivacyViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }

    private void init() {
        viewModel.fetchPrivacyPolicyReport();
        viewModel.observePrivacyPolicyReportMLD().observe(this, viewModel::setPrivacyPolicyReport);
        viewModel.observeIsLoading().observe(this, viewModel::setIsUpload);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
