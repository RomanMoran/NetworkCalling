package com.example.networkcalling.di;

import android.content.Context;

import toothpick.config.Module;

public class AppModule extends Module {

    public AppModule(Context context) {
        bind(Context.class).toInstance(context);
    }

}
