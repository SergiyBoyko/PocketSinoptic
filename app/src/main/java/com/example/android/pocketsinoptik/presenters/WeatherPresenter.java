package com.example.android.pocketsinoptik.presenters;

import com.example.android.pocketsinoptik.activities.MainActivity;
import com.example.android.pocketsinoptik.model.remote.IWeatherDataSource;
import com.example.android.pocketsinoptik.utils.rx.RxErrorAction;
import com.example.android.pocketsinoptik.utils.rx.RxRetryWithDelay;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fbrsw on 10.11.2017.
 */

public class WeatherPresenter extends BasePresenter<MainActivity> {

    private final IWeatherDataSource weatherDataSource;

    public WeatherPresenter(IWeatherDataSource weatherDataSource) {
        this.weatherDataSource = weatherDataSource;
    }

    public void getCurrentWeather(String city) {
        MainActivity view = getView();
        subscribe(weatherDataSource.getCurrentWeather(city)
                .retryWhen(new RxRetryWithDelay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showCurrentWeather, new RxErrorAction(getView().getContext()))
        );
    }

    public void getWeatherForFiveDays(String city) {
        MainActivity view = getView();
        subscribe(weatherDataSource.getWeatherForFiveDays(city)
                .retryWhen(new RxRetryWithDelay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showWeatherForFiveDays, new RxErrorAction(getView().getContext()))
        );
    }

    public void getWeatherForSixteenDays(String city) {
        MainActivity view = getView();
        subscribe(weatherDataSource.getWeatherForSixteenDays(city)
                .retryWhen(new RxRetryWithDelay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showWeatherForSixteenDays, new RxErrorAction(getView().getContext()))
        );
    }
}
