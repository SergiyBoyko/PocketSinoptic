package com.example.android.pocketsinoptik.utils;

import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.SixteenDaysWeatherResponse;

/**
 * Created by fbrsw on 11.11.2017.
 */

public class DataKeeper {

    private SixteenDaysWeatherResponse sixteenDaysWeatherResponse;

    private FiveDaysWeatherResponse fiveDaysWeatherResponse;

    private CurrentWeatherResponse currentWeatherResponse;

    private static DataKeeper instance;

    private DataKeeper() {
        this.sixteenDaysWeatherResponse = null;
        this.fiveDaysWeatherResponse = null;
        this.currentWeatherResponse = null;
    }

    public static DataKeeper getInstance() {
        if (instance == null) {
            instance = new DataKeeper();
        }
        return instance;
    }

    public SixteenDaysWeatherResponse getSixteenDaysWeatherResponse() {
        return sixteenDaysWeatherResponse;
    }

    public void setSixteenDaysWeatherResponse(SixteenDaysWeatherResponse sixteenDaysWeatherResponse) {
        this.sixteenDaysWeatherResponse = sixteenDaysWeatherResponse;
    }

    public FiveDaysWeatherResponse getFiveDaysWeatherResponse() {
        return fiveDaysWeatherResponse;
    }

    public void setFiveDaysWeatherResponse(FiveDaysWeatherResponse fiveDaysWeatherResponse) {
        this.fiveDaysWeatherResponse = fiveDaysWeatherResponse;
    }

    public CurrentWeatherResponse getCurrentWeatherResponse() {
        return currentWeatherResponse;
    }

    public void setCurrentWeatherResponse(CurrentWeatherResponse currentWeatherResponse) {
        this.currentWeatherResponse = currentWeatherResponse;
    }
}
