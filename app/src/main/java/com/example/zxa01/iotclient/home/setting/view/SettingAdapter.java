package com.example.zxa01.iotclient.home.setting.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.zxa01.iotclient.BR;
import com.example.zxa01.iotclient.common.pojo.Setting;
import com.example.zxa01.iotclient.home.setting.viewModel.SettingViewModel;
import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.MyViewHolder> {

    private int layoutId;
    private List<Setting> settings;
    private SettingViewModel viewModel;

    public SettingAdapter(@LayoutRes int layoutId, SettingViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public SettingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SettingAdapter.MyViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(SettingAdapter.MyViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemCount() {
        return settings == null ? 0 : settings.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }


    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        final ViewDataBinding binding;

        MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(SettingViewModel viewModel, Integer position) {
            viewModel.getSettingAt(position);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }


    }

}