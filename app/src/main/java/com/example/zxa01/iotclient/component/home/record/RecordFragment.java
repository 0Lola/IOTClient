package com.example.zxa01.iotclient.component.home.record;

import android.databinding.DataBindingUtil;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_record, container, false);
        binding();
        init();
        return binding.getRoot();
    }

    private void binding() {
        viewModel = new RecordViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        binding.recordRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void init() {
        viewModel.refreshRecord();
        viewModel.observePrivacyChoiceIndicesMLD().observe(this, viewModel::setAdapter);
    }

}
