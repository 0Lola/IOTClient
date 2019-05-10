package com.example.zxa01.iotclient.common.http;

import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyChoice;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;
import com.example.zxa01.iotclient.common.shared.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class Api {

    private static ApiInterface api;

    public static ApiInterface getApi() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://" + Config.getConfig().getGateway())
                    .client(new OkHttpClient.Builder()
                            .build())
                    .addConverterFactory(
                            GsonConverterFactory.create(new GsonBuilder()
                                    .create()))
                    .build();

            api = retrofit.create(ApiInterface.class);
        }
        return api;
    }

    public interface ApiInterface {

        @POST("/api/breeds/list/all")
        Call<Object> login();

        @GET("/device")
        Call<List<Device>> getDevices();

        @GET("/device/{udn}")
        Call<Device> readDevice(@Path("udn") String udn);

        @GET("/device/privacy/{udn}")
        Call<PrivacyPolicyReport> readPrivacyPolicyReportByDevice(@Path("udn") String udn);


        @POST("/choice")
        Call<PrivacyChoice> setPrivacyChoice(@Body PrivacyChoice privacyChoice);

        // TODO
        @GET("/api/breeds/list/all")
        Call<Object> getRecord();

    }
}
