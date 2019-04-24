package com.example.zxa01.iotclient.home.record.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;
import com.example.zxa01.iotclient.home.record.model.RecordModel;
import com.example.zxa01.iotclient.home.record.view.RecordAdapter;
import com.example.zxa01.iotclient.privacy.view.PrivacyActivity;

import java.util.List;

public class RecordViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    private RecordModel recordModel = new RecordModel();
    private RecordAdapter adapter = new RecordAdapter(R.layout.recycler_view_record, this);
    private Context context;

    public RecordViewModel(Context context) {
        this.context = context;
    }

    /**
     * model
     */

    public void refreshRecord() {
        recordModel.fetchRecord();
    }

    public MutableLiveData<List<PrivacyPolicyReport>> observePrivacyPolicyReportsMLD() {
        return recordModel.getPrivacyPolicyReportsMLD();
    }

    /**
     * child model
     */

    public PrivacyPolicyReport getPrivacyPolicyReportAt(Integer index) {
        if (recordModel.getPrivacyPolicyReportsMLD().getValue() != null &&
                index != null &&
                recordModel.getPrivacyPolicyReportsMLD().getValue().size() > index) {
            return recordModel.getPrivacyPolicyReportsMLD().getValue().get(index);
        }
        return null;
    }

    public void onPrivacyPolicyReportClick(Integer index) {
        if (recordModel.getPrivacyPolicyReportsMLD().getValue() != null &&
                index != null &&
                recordModel.getPrivacyPolicyReportsMLD().getValue().size() > index) {
            // TODO detail of device
            context.startActivity(
                    new Intent(context, PrivacyActivity.class)
                            .putExtra("index", index));
        }
    }

    /**
     * adapter
     */

    public RecordAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<PrivacyPolicyReport> privacyPolicyReports) {
        this.isLoading.set(false);
        this.adapter.setPrivacyPolicyReports(privacyPolicyReports);
        this.adapter.notifyDataSetChanged();
    }

}
