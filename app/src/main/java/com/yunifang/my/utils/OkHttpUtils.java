package com.yunifang.my.utils;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.yunifang.my.jsonbean.HomeData;

import java.io.IOException;

/**
 * Created by lenovo on 2017/3/19.
 */

public class OkHttpUtils {

    public static <T> HomeData RequestGet(String Url, final Class<T> tClass,final CallData callData) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T Data = gson.fromJson(string, tClass);
                callData.BackData(Data);
            }
        });
        return null;
    }

    public interface CallData<T> {
        void BackData(T data);
    }
}
