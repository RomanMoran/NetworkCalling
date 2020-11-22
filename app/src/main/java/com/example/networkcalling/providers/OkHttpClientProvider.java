package com.example.networkcalling.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientProvider implements Provider<OkHttpClient> {

    @Inject
    HttpLoggingInterceptor httpLoggingInterceptor;

    @Override
    public OkHttpClient get() {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
}
