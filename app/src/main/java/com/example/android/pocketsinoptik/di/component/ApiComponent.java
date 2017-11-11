package com.example.android.pocketsinoptik.di.component;

import com.example.android.pocketsinoptik.model.remote.IWeatherDataSource;

import javax.inject.Named;

import retrofit2.Retrofit;

/**
 * Created by fbrsw on 10.11.2017.
 */

public interface ApiComponent {

    @Named("openWeatherApi")
    Retrofit retrofit();

    IWeatherDataSource weatherDataSource();

}
