package com.example.android.pocketsinoptik.views;

import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.current_weather.Weather;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.SixteenDaysWeatherResponse;

import java.util.List;

/**
 * Created by fbrsw on 10.11.2017.
 */

public interface WeatherView extends BaseView {

    void showCurrentWeather(CurrentWeatherResponse response);

    void showWeatherForFiveDays(FiveDaysWeatherResponse response);

    void showWeatherForSixteenDays(SixteenDaysWeatherResponse response);

}
