package com.example.zxa01.iotclient.common.http;

import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.index.PrivacyChoiceResponse;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;
import com.example.zxa01.iotclient.common.shared.Config;
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + Config.getConfig().getGateway())
                .client(new OkHttpClient.Builder()
                        .build())
                .addConverterFactory(
                        GsonConverterFactory.create(new GsonBuilder()
                                .create()))
                .build();

        api = retrofit.create(ApiInterface.class);
        return api;
    }

    public interface ApiInterface {

        // 未使用
        @POST("/api/breeds/list/all")
        Call<Object> login();

        // 取得與該gateway所綁定的裝置列表
        @GET("/device")
        Call<List<Device>> readDevices();

        // 新增並綁定裝置與gateway
        @POST("/device/{udn}")
        Call<Device> bindDeviceAndGateway(@Path("udn") String udn);

        // 取得該裝置的隱私政策與相關資料
        @GET("/privacy/{udn}")
        Call<PrivacyPolicyReport> readPrivacyPolicyReportByDevice(@Path("udn") String udn);

        // 表達隱私偏好
        @POST("/choice")
        Call<PrivacyChoiceResponse> setPrivacyChoice(@Body String privacyChoice);

        // 取得隱私偏好記錄
        @GET("/choice")
        Call<List<PrivacyChoiceResponse>> readPrivacyChoiceRecordsByUser();

    }
}
