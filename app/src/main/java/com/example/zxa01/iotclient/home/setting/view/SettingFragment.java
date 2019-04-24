package com.example.zxa01.iotclient.home.setting.view;

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
import com.example.zxa01.iotclient.databinding.FragmentSettingBinding;
import com.example.zxa01.iotclient.home.setting.viewModel.SettingViewModel;

public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;
    private SettingViewModel viewModel;


    public SettingFragment() {
    }

    public static SettingFragment newInstance(String param1, String param2) {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);
        viewModel = new SettingViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        binding.settingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        viewModel.refreshSetting();
        viewModel.observeSettingMLD().observe(this,viewModel::setAdapter);
    }

    public interface OnFragmentInteractionListener {
        void onSettingFragment(Uri uri);
    }
}
