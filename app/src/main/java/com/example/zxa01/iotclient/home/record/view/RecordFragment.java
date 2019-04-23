package com.example.zxa01.iotclient.home.record.view;

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
import com.example.zxa01.iotclient.home.record.viewModel.RecordViewModel;

public class RecordFragment extends Fragment {


    private FragmentRecordBinding binding;
    private RecordViewModel viewModel;

    public RecordFragment() {
    }

    public static RecordFragment newInstance(String param1, String param2) {
        return new RecordFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_record, container, false);
        viewModel = new RecordViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        binding.recordRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        init();
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

    private void init() {
        viewModel.refreshRecord();
        viewModel.observePrivacyPolicyReportsMLDD().observe(this, viewModel::setAdapter);
    }

    public interface OnFragmentInteractionListener {
        void onPrivacyFragment(Uri uri);
    }
}
