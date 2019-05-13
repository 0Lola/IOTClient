package com.example.zxa01.iotclient.component.home.record;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.device.Manufacturer;
import com.example.zxa01.iotclient.common.pojo.device.Model;
import com.example.zxa01.iotclient.common.pojo.index.PrivacyChoiceIndex;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicy;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Access;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Collector;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Datum;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Dispute;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Purpose;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Recipient;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Remedy;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Retention;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecordModel extends BaseObservable {

    private List<PrivacyChoiceIndex> privacyChoiceIndices = new ArrayList<>();
    private MutableLiveData<List<PrivacyChoiceIndex>> privacyChoiceIndicesMLD = new MutableLiveData<>();

    public RecordModel() {
    }

    private void addPrivacyChoiceIndices(PrivacyChoiceIndex privacyChoiceIndex) {
        privacyChoiceIndices.add(privacyChoiceIndex);
    }

    public MutableLiveData<List<PrivacyChoiceIndex>> getPrivacyChoiceIndicesMLD() {
        return privacyChoiceIndicesMLD;
    }

    public void fetchRecord() {
        Api.getApi().readPrivacyChoiceRecordsByUser().enqueue(new Callback<List<PrivacyChoiceIndex>>() {
            @Override
            public void onResponse(Call<List<PrivacyChoiceIndex>> call, Response<List<PrivacyChoiceIndex>> response) {
                // TODO transfer response
                privacyChoiceIndicesMLD.setValue(response == null || response.body() == null ?
                        null : response.body().stream().collect(Collectors.toList()));
            }

            @Override
            public void onFailure(Call<List<PrivacyChoiceIndex>> call, Throwable t) {
            }
        });

    }

}
