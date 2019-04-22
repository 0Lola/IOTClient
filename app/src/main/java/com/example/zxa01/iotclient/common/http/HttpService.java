package com.example.zxa01.iotclient.common.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpService {


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public String doGetSyncRequest(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        Response mResponse=call.execute();
        if (mResponse.isSuccessful()) {
            return mResponse.body().string();
        } else {
            throw new IOException("Unexpected code " + mResponse);
        }
//        call.enqueue(new Callback(){
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                System.out.println(response);
//            }
//        });
//        return client.newCall(
//                new Request.Builder()
//                        .url(HttpUrl.parse(url).newBuilder().build().toString())
//                        .build()
//        ).execute().body().string();
    }

    public String doPostRequest(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        return client.newCall(
                new Request.Builder()
                        .url(url)
                        .post(RequestBody.create(JSON, json))
                        .build()
        ).execute().body().string();
    }
}
