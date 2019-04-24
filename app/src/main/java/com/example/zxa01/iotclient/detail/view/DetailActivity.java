package com.example.zxa01.iotclient.detail.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.ActivityDetailBinding;
import com.example.zxa01.iotclient.detail.viewModel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private DetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        viewModel = new DetailViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }

    public void init(){
        viewModel.fetchDevice();
        viewModel.observeDeviceMLD().observe(this,viewModel::setDevice);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
