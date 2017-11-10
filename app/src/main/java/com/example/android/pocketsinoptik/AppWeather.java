package com.example.android.pocketsinoptik;

import android.support.multidex.MultiDexApplication;

import com.example.android.pocketsinoptik.di.component.AppComponent;
import com.example.android.pocketsinoptik.di.component.DaggerAppComponent;
import com.example.android.pocketsinoptik.di.module.ApiModule;
import com.example.android.pocketsinoptik.di.module.AppModule;

/**
 * Created by fbrsw on 10.11.2017.
 */

public class AppWeather extends MultiDexApplication {

    private AppComponent appComponent;

    public AppWeather() {
        super();

        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }

}
