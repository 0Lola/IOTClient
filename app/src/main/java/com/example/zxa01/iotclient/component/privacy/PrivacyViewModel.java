package com.example.zxa01.iotclient.component.privacy;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyContent;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicy;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;
import com.example.zxa01.iotclient.common.shared.Config;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Switch;

import java.util.List;

public class PrivacyViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableBoolean isUpload = new ObservableBoolean(true);
    public ObservableField<PrivacyPolicyReport> privacyPolicyReport = new ObservableField<>();

    private PrivacyModel privacyModel = new PrivacyModel();
    private PrivacyAdapter adapter = new PrivacyAdapter(R.layout.recycler_view_privacy, this);
    private Context context;
    private AlertDialog dialog;

    public PrivacyViewModel(Context context) {
        this.context = context;
        drawDialog();
    }

    /**
     * model
     */

    public void fetchPrivacyPolicyReportByDevice(@NonNull String udn) {
        privacyModel.readPrivacyPolicyReportByDevice(udn);
    }

    public MutableLiveData<PrivacyPolicyReport> observePrivacyPolicyReportMLD() {
        return privacyModel.getPrivacyPolicyReportMLD();
    }

    public void setPrivacyPolicyReport(PrivacyPolicyReport privacyPolicyReport) {
        if (privacyPolicyReport != null && privacyPolicyReport.getId() != null) {
            this.privacyPolicyReport.set(privacyPolicyReport);
            setAdapter(privacyPolicyReport.getPolicies());
        }
    }

    /**
     * child model
     */

    public PrivacyPolicy getPrivacyAt(@NonNull Integer index) {
        if (privacyModel.getPrivacyPolicyReportMLD().getValue() != null &&
                index != null &&
                privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().size() > index) {
            return privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().get(index);
        }
        return null;
    }

    public void onSetPrivacyChoice(@NonNull Integer index, View view) {
        if (privacyModel.getPrivacyPolicyReportMLD().getValue() != null &&
                privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().size() > index) {
            privacyModel.setPrivacyChoice(
                    new PrivacyContent()
                            .setUser(Config.getConfig().getUser())
                            .setDevice(privacyModel.getPrivacyPolicyReportMLD().getValue().getDevice())
                            .setPolicy(privacyModel.getPrivacyPolicyReportMLD().getValue().getPolicies().get(index)),
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
        isLoading.set(false);
        adapter.setPrivacyPolicyList(privacyPolicies);
    }

}
