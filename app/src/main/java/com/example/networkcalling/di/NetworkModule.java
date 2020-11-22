package com.example.networkcalling.di;

import com.example.networkcalling.providers.HttpLoggingInterceptorProvider;
import com.example.networkcalling.providers.OkHttpClientProvider;
import com.example.networkcalling.providers.RetrofitProvider;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import toothpick.config.Module;

public class NetworkModule extends Module {

    public NetworkModule() {
        bind(HttpLoggingInterceptor.class).toProvider(HttpLoggingInterceptorProvider.class);
        bind(OkHttpClient.class).toProvider(OkHttpClientProvider.class);
        bind(Retrofit.class).toProvider(RetrofitProvider.class);
    }

}
