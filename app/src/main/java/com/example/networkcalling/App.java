package com.example.networkcalling;

import com.example.networkcalling.di.AppModule;
import com.example.networkcalling.di.NetworkModule;
import com.example.networkcalling.di.RepositoryModule;

import toothpick.Scope;
import toothpick.Toothpick;

public class App extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Scope appScope = Toothpick.openScope("APP");
        appScope.installModules(
                new AppModule(getApplicationContext()),
                new RepositoryModule(),
                new NetworkModule()
        );
    }

}
