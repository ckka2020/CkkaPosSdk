package com.ckka.ckkapossdk.api;

import com.ckka.ckkapossdk.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {
    private static Retrofit retrofit = null;
    private static APIInterface apiInterface = null;

    public static Retrofit getClient() {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.SECONDS) // connect timeout
                    .writeTimeout(30, TimeUnit.SECONDS) // write timeout
                    .readTimeout(30, TimeUnit.SECONDS) // read timeout
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public static APIInterface getApiInterface() {
        if (apiInterface == null) {
            apiInterface = getClient().create(APIInterface.class);
        }
        return apiInterface;
    }
}