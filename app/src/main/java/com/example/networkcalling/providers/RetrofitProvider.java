package com.example.networkcalling.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider implements Provider<Retrofit> {

    @Inject
    OkHttpClient httpClient;

    private final String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    @Override
    public Retrofit get() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
