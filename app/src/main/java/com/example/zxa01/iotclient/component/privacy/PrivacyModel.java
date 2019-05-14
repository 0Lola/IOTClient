package com.example.zxa01.iotclient.component.privacy;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.index.PrivacyChoiceResponse;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyChoice;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyContent;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;
import com.example.zxa01.iotclient.common.shared.Config;
import com.google.gson.Gson;

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

    public void readPrivacyPolicyReportByDevice(@NonNull String udn) {
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


    public void setPrivacyChoice(@NonNull PrivacyContent privacyContent, @NonNull boolean isAccepted) {
        isUploadMLD.setValue(true);
        Api.getApi().setPrivacyChoice(transferPrivacyContent(privacyContent, isAccepted))
                .enqueue(new Callback<PrivacyChoiceResponse>() {
                    @Override
                    public void onResponse(Call<PrivacyChoiceResponse> call, Response<PrivacyChoiceResponse> response) {
                        dialogDelay();
                    }

                    @Override
                    public void onFailure(Call<PrivacyChoiceResponse> call, Throwable t) {
                        dialogDelay();
                        Log.e("setPrivacyChoice - onFailure()", t.getMessage(), t);
                    }
                });
    }

    private void dialogDelay() {
        new Handler().postDelayed(() -> isUploadMLD.setValue(false), 500);
    }

    private String transferPrivacyContent(@NonNull PrivacyContent privacyContent, @NonNull boolean isAccepted) {
        return new Gson().toJson(
                new PrivacyChoice().setPrivacyContent(
                        privacyContent.setUser(Config.getConfig().getUser()))
                        .setAccepted(isAccepted));
    }

}
