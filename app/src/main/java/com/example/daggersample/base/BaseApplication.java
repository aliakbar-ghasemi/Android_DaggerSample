package com.example.daggersample.base;

import android.app.Application;

import com.example.daggersample.di.component.ApiComponent;
import com.example.daggersample.di.component.DaggerApiComponent;
import com.example.daggersample.di.module.ApiModule;
import com.example.daggersample.di.module.AppModule;

public class BaseApplication extends Application {
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}
