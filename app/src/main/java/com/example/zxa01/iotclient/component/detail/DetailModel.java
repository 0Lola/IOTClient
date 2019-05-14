package com.example.zxa01.iotclient.component.detail;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailModel extends BaseObservable {

    private MutableLiveData<Device> deviceMLD = new MutableLiveData<>();

    public DetailModel() {
    }

    public MutableLiveData<Device> getDeviceMLD() {
        return deviceMLD;
    }

    public void setDeviceMLD(@NonNull Device device) {
        deviceMLD.setValue(device);
    }

    public void readDevice(@NonNull String udn) {
        Api.getApi().readPrivacyPolicyReportByDevice(udn).enqueue(new Callback<PrivacyPolicyReport>() {
            @Override
            public void onResponse(Call<PrivacyPolicyReport> call, Response<PrivacyPolicyReport> response) {
                setDeviceMLD(response == null || response.body() == null ?
                        null : response.body().getDevice());
            }

            @Override
            public void onFailure(Call<PrivacyPolicyReport> call, Throwable t) {
                Log.e("readDevice - onFailure()", t.getMessage(), t);
            }
        });

    }

}
