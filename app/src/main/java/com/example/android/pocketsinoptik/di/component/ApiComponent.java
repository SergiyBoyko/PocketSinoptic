package com.example.android.pocketsinoptik.di.component;

import com.example.android.pocketsinoptik.model.remote.IWeatherDataSource;

import retrofit2.Retrofit;

/**
 * Created by fbrsw on 10.11.2017.
 */

public interface ApiComponent {

    Retrofit retrofit();

    IWeatherDataSource weatherDataSource();

}
