package com.example.android.pocketsinoptik.model.remote;

import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.SixteenDaysWeatherResponse;

import rx.Observable;

/**
 * Created by fbrsw on 09.11.2017.
 */

public interface IWeatherDataSource {

    Observable<CurrentWeatherResponse> getCurrentWeather(String city);

    Observable<FiveDaysWeatherResponse> getWeatherForFiveDays(String city);

    Observable<SixteenDaysWeatherResponse> getWeatherForSixteenDays(String city);

}
