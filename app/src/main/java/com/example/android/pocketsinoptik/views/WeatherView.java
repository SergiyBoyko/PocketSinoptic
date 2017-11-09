package com.example.android.pocketsinoptik.views;

import com.example.android.pocketsinoptik.model.entities.current_weather.Weather;

import java.util.List;

/**
 * Created by fbrsw on 10.11.2017.
 */

public interface WeatherView extends BaseView {

    void showCurrentWeather(List<Weather> weather);

    void showWeatherForFiveDays(List<com.example.android.pocketsinoptik.model.entities.five_days_weather.List> lists);

    void showWeatherForSixteenDays(List<com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.List> lists);

}
