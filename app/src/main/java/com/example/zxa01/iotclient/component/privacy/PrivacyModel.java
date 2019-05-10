package com.example.zxa01.iotclient.component.privacy;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.os.Handler;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyChoice;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyContent;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrivacyModel extends BaseObservable {

    private MutableLiveData<Boolean> isUploadMLD = new MutableLiveData<>();
    private MutableLiveData<PrivacyPolicyReport> privacyPolicyReportMLD = new MutableLiveData<>();

    public PrivacyModel() {
        privacyPolicyReportMLD.setValue(new PrivacyPolicyReport());
        isUploadMLD.setValue(false);
    }

    public MutableLiveData<PrivacyPolicyReport> getPrivacyPolicyReportMLD() {
        return privacyPolicyReportMLD;
    }

    public MutableLiveData<Boolean> getIsUploadMLD() {
        return isUploadMLD;
    }

    public void readPrivacyPolicyReportByDevice(String udn) {
        Api.getApi().readPrivacyPolicyReportByDevice(udn).enqueue(new Callback<PrivacyPolicyReport>() {
            @Override
            public void onResponse(Call<PrivacyPolicyReport> call, Response<PrivacyPolicyReport> response) {
                privacyPolicyReportMLD.setValue(response.body());
            }

            @Override
            public void onFailure(Call<PrivacyPolicyReport> call, Throwable t) {
                Log.e("readPrivacyPolicyReportByDevice - onFailure()", t.getMessage(), t);
            }
        });
    }


    public void setPrivacyChoice(PrivacyContent privacyContent, boolean isAccepted) {
        isUploadMLD.setValue(true);
        Api.getApi().setPrivacyChoice(
                new PrivacyChoice().setPrivacyContent(privacyContent).setAccepted(isAccepted)).enqueue(
                new Callback<PrivacyChoice>() {
                    @Override
                    public void onResponse(Call<PrivacyChoice> call, Response<PrivacyChoice> response) {
                        new Handler().postDelayed(() -> isUploadMLD.setValue(false), 500);
                    }

                    @Override
                    public void onFailure(Call<PrivacyChoice> call, Throwable t) {
                        Log.e("setPrivacyChoice - onFailure()", t.getMessage(), t);
                    }
                });
    }

}
