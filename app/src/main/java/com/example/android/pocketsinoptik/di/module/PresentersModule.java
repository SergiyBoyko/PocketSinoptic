package com.example.android.pocketsinoptik.di.module;

import com.example.android.pocketsinoptik.di.scope.Scope;
import com.example.android.pocketsinoptik.di.scope.Scopes;
import com.example.android.pocketsinoptik.model.remote.IWeatherDataSource;
import com.example.android.pocketsinoptik.presenters.WeatherPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fbrsw on 10.11.2017.
 */

@Module
public class PresentersModule {

    @Provides
    @Scope(Scopes.VIEW)
    public WeatherPresenter provideWeatherPresenter(IWeatherDataSource weatherDataSource) {
        return new WeatherPresenter(weatherDataSource);
    }

}
