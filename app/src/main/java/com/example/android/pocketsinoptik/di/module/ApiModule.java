package com.example.android.pocketsinoptik.di.module;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.api.OpenWeatherApiSet;
import com.example.android.pocketsinoptik.model.remote.IWeatherDataSource;
import com.example.android.pocketsinoptik.model.remote.WeatherDataSource;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fbrsw on 10.11.2017.
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofitForDogs() {
        return new Retrofit.Builder()
                .baseUrl(Constants.OPEN_WEATHER_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    IWeatherDataSource provideWeatherDataSource(Retrofit retrofit) {
        return new WeatherDataSource(retrofit.create(OpenWeatherApiSet.class));
    }
}
