package com.example.zxa01.iotclient.component.home.record;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.zxa01.iotclient.BR;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {

    private int layoutId;
    private List<PrivacyPolicyReport> privacyPolicyReports;
    private RecordViewModel viewModel;

    public RecordAdapter(@LayoutRes int layoutId, RecordViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public RecordAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecordAdapter.MyViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(RecordAdapter.MyViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemCount() {
        return privacyPolicyReports == null ? 0 : privacyPolicyReports.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setPrivacyPolicyReports(List<PrivacyPolicyReport> privacyPolicyReports) {
        this.privacyPolicyReports = privacyPolicyReports;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        final ViewDataBinding binding;

        MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(RecordViewModel viewModel, Integer position) {
            viewModel.getPrivacyPolicyReportAt(position);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }

    }

}
