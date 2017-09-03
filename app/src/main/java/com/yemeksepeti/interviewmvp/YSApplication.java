package com.yemeksepeti.interviewmvp;

import android.app.Application;
import android.content.Context;

import com.yemeksepeti.interviewmvp.rest.RestService;
import com.yemeksepeti.interviewmvp.util.Constants;
import com.yemeksepeti.interviewmvp.util.Fonty;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class YSApplication extends Application {

    private static Context context;
    private static RestService restService;
    public static RestService getRestService() {
        return restService;
    }

    public static Context getAppContext() {
        return YSApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        YSApplication.context = getApplicationContext();
        Fonty.builder(getApplicationContext());

        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restService = retrofit.create(RestService.class);

    }

}
