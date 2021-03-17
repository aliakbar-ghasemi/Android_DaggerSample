package com.example.daggersample.di.component;

import com.example.daggersample.MainActivity;
import com.example.daggersample.di.module.ApiModule;
import com.example.daggersample.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}