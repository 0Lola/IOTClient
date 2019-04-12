package com.example.zxa01.iotclient.home.setting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.pojo.Setting;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SettingFragment extends Fragment {


    @BindView(R.id.setting_recycler_view)
    RecyclerView settingRecyclerView;
    Unbinder unbinder;

    private LinkedList<Setting> mList = new LinkedList<>();
    private RecyclerView mRecyclerView;

    private OnFragmentInteractionListener mListener;

    public SettingFragment() {
        // fake data
        mList.add(new Setting("Gateway address", "192.168.2.69"));
        mList.add(new Setting("Account", "Test"));
        mList.add(new Setting("HTTP port", "8080"));
        mList.add(new Setting("WebSocket port", "8081"));
        mList.add(new Setting("Log out", "exchange account"));

    }

    public static SettingFragment newInstance(String param1, String param2) {
        return new SettingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        unbinder = ButterKnife.bind(this, view);
        if(savedInstanceState == null){
            buildRecyclerView(view);
        }
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSettingFragment(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnFragmentInteractionListener {
        void onSettingFragment(Uri uri);
    }

    public void buildRecyclerView(View view){
        mRecyclerView = view.findViewById(R.id.setting_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new SettingAdapter(mList));
    }
}
