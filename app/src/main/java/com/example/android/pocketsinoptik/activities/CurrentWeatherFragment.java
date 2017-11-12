package com.example.android.pocketsinoptik.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.R;
import com.example.android.pocketsinoptik.model.entities.current_weather.CurrentWeatherResponse;
import com.example.android.pocketsinoptik.model.entities.five_days_weather.FiveDaysWeatherResponse;
import com.example.android.pocketsinoptik.utils.DataKeeper;
import com.example.android.pocketsinoptik.utils.ImagePack;
import com.example.android.pocketsinoptik.utils.ImageSelector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fbrsw on 08.11.2017.
 */

public class CurrentWeatherFragment extends Fragment {

    @BindView(R.id.city_name)
    TextView cityField;
    @BindView(R.id.date_update)
    TextView updatedField;
    @BindView(R.id.details)
    TextView detailsField;
    @BindView(R.id.current_temp)
    TextView currentTemperatureField;
    @BindView(R.id.weather_ico)
    ImageView weatherIcon;
    @BindView(R.id.weather_bg)
    ImageView weatherBg;

    private CurrentWeatherResponse response;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_card, null);

        ButterKnife.bind(this, view);

        DataKeeper dataKeeper = DataKeeper.getInstance();

        refreshInfo();

        view.findViewById(R.id.frame).setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(Constants.EXTRA_POSITION, 0);
            context.startActivity(intent);
        });
        return view;
    }

    public void refreshInfo() {
        DataKeeper dataKeeper = DataKeeper.getInstance();

        if (dataKeeper.getCurrentWeatherResponse() != null){
            try {
                cityField.setText(dataKeeper.getCurrentWeatherResponse().getName());

                long ms = dataKeeper.getCurrentWeatherResponse().getDt() * 1000;
                Date date = new Date(ms);
                String dayPart = (date.getHours() > 7 && date.getHours() < 19) ? Constants.DAY : Constants.NIGHT;

                SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.SHORT_DATE_FORMAT, Locale.ENGLISH);
                updatedField.setText(dateFormat.format(new Date(ms)));

                ImagePack pack = ImageSelector.getImagePackById(view.getContext(), dataKeeper.getCurrentWeatherResponse().getWeather().get(0).getId(), dayPart);
                weatherIcon.setImageDrawable(pack.getIcon());
                weatherBg.setImageDrawable(pack.getBackGround());
                detailsField.setText(pack.getDescription());
            } catch (Exception e) {
                Toast.makeText(view.getContext(), "Error in respond", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
}
