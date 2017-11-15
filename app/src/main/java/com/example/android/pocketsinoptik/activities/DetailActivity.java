package com.example.android.pocketsinoptik.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.R;
import com.example.android.pocketsinoptik.utils.ImagePack;
import com.example.android.pocketsinoptik.utils.ImageSelector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.desc)
    TextView descField;

    @BindView(R.id.temperature)
    TextView tempField;

    @BindView(R.id.date)
    TextView dateField;

    @BindView(R.id.image)
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        ButterKnife.bind(this);

        String cityName = getIntent().getStringExtra(Constants.CITY);
        long ms = getIntent().getLongExtra(Constants.DATE, 0L);
        Date date = new Date(ms);
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.EXPAND_DATE_FORMAT, Locale.ENGLISH);
        String timeDate = dateFormat.format(date);
        String temperature = getIntent().getStringExtra(Constants.TEMPERATURE);
        int weatherId = getIntent().getIntExtra(Constants.WEATHER_ID, 0);
        String dayPart = (date.getHours() > 7 && date.getHours() < 19) ? Constants.DAY : Constants.NIGHT;
        ImagePack pack = ImageSelector.getImagePackById(this, weatherId, dayPart);

        collapsingToolbar.setTitle(cityName);

        descField.setText(pack.getDescription());

        tempField.setText(temperature);

        dateField.setText(timeDate);

        image.setImageDrawable(pack.getBackGround());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            // CurrentWeatherResponse to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
