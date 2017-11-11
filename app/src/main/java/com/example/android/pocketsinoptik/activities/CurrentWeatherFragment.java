package com.example.android.pocketsinoptik.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.R;
import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;

/**
 * Created by fbrsw on 08.11.2017.
 */

public class CurrentWeatherFragment extends Fragment {

    private CurrentWeatherResponse response;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_card, null);
        view.findViewById(R.id.frame).setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(Constants.EXTRA_POSITION, 0);
            context.startActivity(intent);
        });
        return view;
    }

    public void setResponse(CurrentWeatherResponse response) {
        this.response = response;
    }
}
