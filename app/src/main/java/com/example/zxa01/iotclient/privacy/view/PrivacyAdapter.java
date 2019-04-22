package com.example.zxa01.iotclient.privacy.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zxa01.iotclient.BR;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicy;
import com.example.zxa01.iotclient.home.device.viewModel.DeviceViewModel;
import com.example.zxa01.iotclient.privacy.viewModel.PrivacyViewModel;

import java.util.List;

public class PrivacyAdapter extends RecyclerView.Adapter<PrivacyAdapter.MyViewHolder> {

    private int layoutId;
    private List<PrivacyPolicy> privacyPolicyList;
    private PrivacyViewModel viewModel;

    public PrivacyAdapter(@LayoutRes int layoutId, PrivacyViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemCount() {
        return privacyPolicyList == null ? 0 : privacyPolicyList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setDevices(List<PrivacyPolicy> privacyPolicyList) {
        this.privacyPolicyList = privacyPolicyList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        final ViewDataBinding binding;

        MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(PrivacyViewModel viewModel, Integer position) {
            viewModel.getPrivacyAt(position);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }

    }

}