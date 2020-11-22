package com.example.networkcalling.di;

import com.example.networkcalling.network.ApiService;
import com.example.networkcalling.network.AppApiClient;
import com.example.networkcalling.network.RetrofitGenerator;

import toothpick.config.Module;

public class NetworkModule extends Module {

    public NetworkModule() {
        bind(ApiService.class).toInstance(new RetrofitGenerator().buildRetrofit().create(ApiService.class));
        bind(AppApiClient.class);
    }

}
