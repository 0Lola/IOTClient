package com.example.zxa01.iotclient.component.home.record;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.index.PrivacyChoiceResponse;
import com.example.zxa01.iotclient.component.privacy.PrivacyActivity;

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

    public MutableLiveData<List<PrivacyChoiceResponse>> observePrivacyChoiceIndicesMLD() {
        return recordModel.getPrivacyChoiceResponsesMLD();
    }

    /**
     * child model
     */

    public PrivacyChoiceResponse getPrivacyChoiceAt(@NonNull Integer index) {
        if (recordModel.getPrivacyChoiceResponsesMLD().getValue() != null &&
                recordModel.getPrivacyChoiceResponsesMLD().getValue().size() > index) {
            return recordModel.getPrivacyChoiceResponsesMLD().getValue().get(index);
        }
        return null;
    }

    public void onPrivacyChoiceClick(@NonNull Integer index) {
        if (recordModel.getPrivacyChoiceResponsesMLD().getValue() != null &&
                recordModel.getPrivacyChoiceResponsesMLD().getValue().size() > index) {
            context.startActivity(
                    new Intent(context, PrivacyActivity.class)
                            .putExtra("udn",
                                    recordModel.getPrivacyChoiceResponsesMLD().getValue().get(index)
                                            .getPrivacyContent().getDevice().getUdn()));
        }
    }

    /**
     * adapter
     */

    public RecordAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<PrivacyChoiceResponse> privacyChoiceResponses) {
        isLoading.set(false);
        adapter.setPrivacyChoiceResponses(privacyChoiceResponses);
    }

}
