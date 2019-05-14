package com.example.zxa01.iotclient.component.home.record;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.index.PrivacyChoiceResponse;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecordModel extends BaseObservable {

    private MutableLiveData<List<PrivacyChoiceResponse>> privacyChoiceResponsesMLD = new MutableLiveData<>();

    public RecordModel() {
    }

    public MutableLiveData<List<PrivacyChoiceResponse>> getPrivacyChoiceResponsesMLD() {
        return privacyChoiceResponsesMLD;
    }

    public void fetchRecord() {
        Api.getApi().readPrivacyChoiceRecordsByUser().enqueue(new Callback<List<PrivacyChoiceResponse>>() {
            @Override
            public void onResponse(Call<List<PrivacyChoiceResponse>> call, @NonNull Response<List<PrivacyChoiceResponse>> response) {
                privacyChoiceResponsesMLD.setValue(response.body() == null ?
                        null : response.body().stream().collect(Collectors.toList()));
            }

            @Override
            public void onFailure(Call<List<PrivacyChoiceResponse>> call, Throwable t) {
                Log.e("fetchRecord - onFailure()", t.getMessage(), t);
            }
        });

    }

}
