package com.example.zxa01.iotclient.component.home.record;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.FragmentRecordBinding;

public class RecordFragment extends Fragment {

    private FragmentRecordBinding binding;
    private RecordViewModel viewModel;

    public RecordFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_record, container, false);
        this.viewModel = new RecordViewModel(binding.getRoot().getContext());
        this.binding.setViewModel(viewModel);
        this.binding.recordRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        init();
        return binding.getRoot();
    }

    private void init() {
        this.viewModel.refreshRecord();
        this.viewModel.observePrivacyPolicyReportsMLD().observe(this, viewModel::setAdapter);
    }

}
