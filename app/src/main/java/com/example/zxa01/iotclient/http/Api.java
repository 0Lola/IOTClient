package com.example.zxa01.iotclient.http;

import com.example.zxa01.iotclient.home.device.model.DeviceModel;
import com.example.zxa01.iotclient.home.device.model.DevicesModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api {

    private static ApiInterface api;
    private static final String BASE_URL = "https://dog.ceo";

    public static ApiInterface getApi() {
        if (api == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            Gson gson = new GsonBuilder()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(
                            GsonConverterFactory.create(gson))
                    .build();

            api = retrofit.create(ApiInterface.class);
        }
        return api;
    }

    public interface ApiInterface {
        @GET("/api/breeds/list/all")
        Call<Object> getDevices();
//        @GET("/api/breed/{breed}/images")
//        Call<DogBreedImages> getImagesByBreed(@Path("breed") String breed);

    }
}
