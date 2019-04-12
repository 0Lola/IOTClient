package com.example.zxa01.iotclient.home.setting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.pojo.Setting;

import java.util.LinkedList;


public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.MyViewHolder> {

    private final LinkedList<Setting> mList;

    public SettingAdapter(LinkedList<Setting> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_setting, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder mholder, int position) {
        Setting setting = mList.get(position);
        mholder.position = position;
        mholder.textSettingKey.setText(setting.getKey());
        mholder.textSettingValue.setText(setting.getValue());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public int position;
        public TextView textSettingKey;
        public TextView textSettingValue;

        public MyViewHolder(View view) {
            super(view);
            this.textSettingKey = view.findViewById(R.id.text_setting_key);
            this.textSettingValue = view.findViewById(R.id.text_setting_value);
        }

        @Override
        public void onClick(View v) {
        }
    }

}