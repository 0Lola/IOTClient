package com.example.zxa01.iotclient.home.device;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.pojo.Device;

import java.util.LinkedList;


public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.MyViewHolder> {

    private final LinkedList<Device> mList;

    public DeviceAdapter(LinkedList<Device> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_device, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder mholder, int position) {
        Device device = mList.get(position);
        mholder.position = position;
        mholder.textDeviceName.setText(device.getName());
        mholder.textDeviceSubtitle.setText(device.getSubTitle());
        mholder.textDeviceStatus.setText(device.isStatus() ? "Connection" : "Disconnection");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public int position;
        public TextView textDeviceName;
        public TextView textDeviceSubtitle;
        public TextView textDeviceStatus;

        public MyViewHolder(View view) {
            super(view);
            this.textDeviceName = view.findViewById(R.id.text_device_name);
            this.textDeviceSubtitle = view.findViewById(R.id.text_device_subtitle);
            this.textDeviceStatus = view.findViewById(R.id.text_device_status);
        }

        @Override
        public void onClick(View v) {
        }
    }

}