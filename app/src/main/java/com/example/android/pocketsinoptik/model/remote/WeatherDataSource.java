package com.example.android.pocketsinoptik.model.remote;

import com.example.android.pocketsinoptik.api.OpenWeatherApi;
import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.SixteenDaysWeatherResponse;

import rx.Observable;

/**
 * Created by fbrsw on 09.11.2017.
 */

public class WeatherDataSource implements IWeatherDataSource {

    OpenWeatherApi openWeatherApi;

    public WeatherDataSource(OpenWeatherApi openWeatherApi) {
        this.openWeatherApi = openWeatherApi;
    }

    @Override
    public Observable<CurrentWeatherResponse> getCurrentWeather(String city) {
        return openWeatherApi.getCurrentWeather(city);
    }

    @Override
    public Observable<FiveDaysWeatherResponse> getWeatherForFiveDays(String city) {
        return openWeatherApi.getWeatherForFiveDays(city);
    }

    @Override
    public Observable<SixteenDaysWeatherResponse> getWeatherForSixteenDays(String city) {
        return openWeatherApi.getWeatherForSixteenDays(city);
    }

}
