package com.example.zxa01.iotclient.component.privacy;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicy;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Switch;
import java.util.List;

public class PrivacyViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableBoolean isUpload = new ObservableBoolean(true);
    public ObservableField<PrivacyPolicyReport> privacyPolicyReport = new ObservableField<>(new PrivacyPolicyReport());
    private PrivacyModel privacyModel = new PrivacyModel();
    private PrivacyAdapter adapter = new PrivacyAdapter(R.layout.recycler_view_privacy, this);
    private Context context;
    private AlertDialog dialog;

    public PrivacyViewModel(Context context) {
        this.context = context;
        this.drawDialog();
    }

    /**
     * model
     */

    public void fetchPrivacyPolicyReport() {
        privacyModel.fetchPrivacyPolicyReport();
    }

    public MutableLiveData<PrivacyPolicyReport> observePrivacyPolicyReportMLD() {
        return privacyModel.getPrivacyPolicyReportMLD();
    }

    public void setPrivacyPolicyReport(PrivacyPolicyReport privacyPolicyReport) {
        if (privacyPolicyReport.getId() != null) {
            this.isLoading.set(false);
            this.privacyPolicyReport.set(privacyPolicyReport);
            this.setAdapter(privacyPolicyReport.getPolicies());
        }
    }

    public void updateP3P() {
        // TODO accpet privacy
    }

    /**
     * child model
     */

    public PrivacyPolicy getPrivacyAt(Integer index) {
        if (privacyModel.getPrivacyPolicyReportMLD().getValue() != null &&
                index != null &&
                privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().size() > index) {
            return privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().get(index);
        }
        return null;
    }

    public void onChangeClick(Integer index, View view) {
        if (privacyModel.getPrivacyPolicyReportMLD().getValue() != null &&
                index != null &&
                privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().size() > index) {
            // TODO change pp
            privacyModel.updatePrivacyPolicyChoice(
                    privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().get(index).getId(),
                    ((Switch) view).isChecked());
        }
    }

    public MutableLiveData<Boolean> observeIsLoadingMLD() {
        return privacyModel.getIsUploadMLD();
    }

    public void setIsUpload(Boolean isUpload) {
        this.isUpload.set(isUpload);
        if (isUpload) {
            dialog.show();
        } else {
            dialog.hide();
        }
    }

    private void drawDialog() {
        dialog = new AlertDialog.Builder(context)
                .setMessage(R.string.privacy_loading_message)
                .setTitle(R.string.privacy_loading_title)
                .create();
    }


    /**
     * adapter
     */

    public PrivacyAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<PrivacyPolicy> privacyPolicies) {
        adapter.setPrivacyPolicyList(privacyPolicies);
        adapter.notifyDataSetChanged();
    }

}
