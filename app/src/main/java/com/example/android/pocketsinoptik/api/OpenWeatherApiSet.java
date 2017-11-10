package com.example.android.pocketsinoptik.api;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.SixteenDaysWeatherResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fbrsw on 09.11.2017.
 */

public interface OpenWeatherApiSet {

    @GET(Constants.ONE_DAY_WEATHER + "?APPID=" + Constants.OPEN_WEATHER_API_KEY + "&units=" + Constants.CELSIUS)
    Observable<CurrentWeatherResponse> getCurrentWeather(@Query("q") String city);

    @GET(Constants.FIVE_DAYS_FORECAST + "?APPID=" + Constants.OPEN_WEATHER_API_KEY + "&units=" + Constants.CELSIUS)
    Observable<FiveDaysWeatherResponse> getWeatherForFiveDays(@Query("q") String city);

    @GET(Constants.SIXTEEN_DAYS_FORECAST + "?APPID=" + Constants.OPEN_WEATHER_API_KEY + "&cnt=" + Constants.DAYS_COUNT + "&units=" + Constants.CELSIUS)
    Observable<SixteenDaysWeatherResponse> getWeatherForSixteenDays(@Query("q") String city);

}
