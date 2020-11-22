package com.example.networkcalling.providers;

import com.example.networkcalling.network.ApiService;

import javax.inject.Inject;
import javax.inject.Provider;

import retrofit2.Retrofit;

public class ApiServiceProvider implements Provider<ApiService> {

    @Inject
    Retrofit retrofit;

    @Override
    public ApiService get() {
        return retrofit.create(ApiService.class);
    }
}
