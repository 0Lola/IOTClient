package com.example.zxa01.iotclient.component.home;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

public class HomeViewModel extends ViewModel {

    private Context context;
    private HomeModel homeModel = new HomeModel();

    public HomeViewModel(Context context) {
        this.context = context;
    }


}
