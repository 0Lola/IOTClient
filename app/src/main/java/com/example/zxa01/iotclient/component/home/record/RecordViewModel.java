package com.example.zxa01.iotclient.component.home.record;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.common.pojo.index.PrivacyChoiceIndex;
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

    public MutableLiveData<List<PrivacyChoiceIndex>> observePrivacyChoiceIndicesMLD() {
        return recordModel.getPrivacyChoiceIndicesMLD();
    }

    /**
     * child model
     */

    public PrivacyChoiceIndex getPrivacyChoiceAt(@NonNull Integer index) {
        if (recordModel.getPrivacyChoiceIndicesMLD().getValue() != null &&
                recordModel.getPrivacyChoiceIndicesMLD().getValue().size() > index) {
            return recordModel.getPrivacyChoiceIndicesMLD().getValue().get(index);
        }
        return null;
    }

    public void onPrivacyChoiceClick(@NonNull Integer index) {
        if (recordModel.getPrivacyChoiceIndicesMLD().getValue() != null &&
                recordModel.getPrivacyChoiceIndicesMLD().getValue().size() > index) {
            context.startActivity(
                    new Intent(context, PrivacyActivity.class)
                            .putExtra("udn",
                                    recordModel.getPrivacyChoiceIndicesMLD().getValue().get(index)
                                            .getPrivacyChoice().getPrivacyContent().getDevice().getUdn()));
        }
    }

    /**
     * adapter
     */

    public RecordAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(List<PrivacyChoiceIndex> privacyChoiceIndices) {
        isLoading.set(false);
        adapter.setPrivacyChoiceIndices(privacyChoiceIndices);
    }

}
