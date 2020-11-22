package com.example.networkcalling.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.logging.HttpLoggingInterceptor;

public class HttpLoggingInterceptorProvider implements Provider<HttpLoggingInterceptor> {

    @Inject
    public HttpLoggingInterceptorProvider() {
    }

    @Override
    public HttpLoggingInterceptor get() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
