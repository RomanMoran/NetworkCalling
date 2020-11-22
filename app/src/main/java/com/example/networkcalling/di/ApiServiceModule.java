package com.example.networkcalling.di;

import com.example.networkcalling.network.ApiService;
import com.example.networkcalling.network.AppApiClient;
import com.example.networkcalling.providers.ApiServiceProvider;

import toothpick.config.Module;

public class ApiServiceModule extends Module {

    public ApiServiceModule() {
        bind(ApiService.class).toProvider(ApiServiceProvider.class);
        bind(AppApiClient.class);
    }
}
