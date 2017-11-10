package com.example.android.pocketsinoptik.model.remote;

import com.example.android.pocketsinoptik.api.OpenWeatherApiSet;
import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.SixteenDaysWeatherResponse;

import rx.Observable;

/**
 * Created by fbrsw on 09.11.2017.
 */

public class WeatherDataSource implements IWeatherDataSource {

    OpenWeatherApiSet openWeatherApiSet;

    public WeatherDataSource(OpenWeatherApiSet openWeatherApiSet) {
        this.openWeatherApiSet = openWeatherApiSet;
    }

    @Override
    public Observable<CurrentWeatherResponse> getCurrentWeather(String city) {
        return openWeatherApiSet.getCurrentWeather(city);
    }

    @Override
    public Observable<FiveDaysWeatherResponse> getWeatherForFiveDays(String city) {
        return openWeatherApiSet.getWeatherForFiveDays(city);
    }

    @Override
    public Observable<SixteenDaysWeatherResponse> getWeatherForSixteenDays(String city) {
        return openWeatherApiSet.getWeatherForSixteenDays(city);
    }

}
