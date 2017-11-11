package com.example.android.pocketsinoptik.activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.android.pocketsinoptik.AppWeather;
import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.R;
import com.example.android.pocketsinoptik.di.component.AppComponent;
import com.example.android.pocketsinoptik.di.component.DaggerPresentersComponent;
import com.example.android.pocketsinoptik.di.module.PresentersModule;
import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.SixteenDaysWeatherResponse;
import com.example.android.pocketsinoptik.presenters.WeatherPresenter;
import com.example.android.pocketsinoptik.views.WeatherView;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements WeatherView {

    @Inject
    WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        DaggerPresentersComponent.builder()
                .appComponent(getAppComponent())
                .presentersModule(new PresentersModule())
                .build()
                .inject(this);
//
//        ButterKnife.bind(this);
//
        weatherPresenter.setView(this);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                showToast(place.getName().toString());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                showToast(getString(R.string.request_google_place_has_failed));
            }
        });

//        weatherPresenter.getCurrentWeather("London");
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showCurrentWeather(CurrentWeatherResponse response) {
        showToast(response.getName());
    }

    @Override
    public void showWeatherForFiveDays(FiveDaysWeatherResponse response) {
        showToast(response.getCity().getName());

    }

    @Override
    public void showWeatherForSixteenDays(SixteenDaysWeatherResponse response) {
        showToast(response.getCity().getName());
    }

    public AppComponent getAppComponent() {
        return ((AppWeather) getApplication()).appComponent();
    }

    private void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new CardContentFragment(), getResources().getString(R.string.tab_layout_first));
        adapter.addFragment(new TileContentFragment(), getResources().getString(R.string.tab_layout_second));
        adapter.addFragment(new ListContentFragment(), getResources().getString(R.string.tab_layout_third));
        viewPager.setAdapter(adapter);
    }

    private static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
