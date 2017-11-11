package com.example.android.pocketsinoptik.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.R;

import java.util.Date;

/**
 * Created by fbrsw on 11.11.2017.
 */

public class ImageSelector {

    // may to be extended
    public static ImagePack getImagePackById(Context context, int actualId, String timeOfDay) {

        int id = actualId / 100;
        ImagePack pack = null;

        if (actualId == 800) {
            if (timeOfDay.equals(Constants.DAY)) {
                pack = new ImagePack(context.getResources().getDrawable(R.drawable.sunny_ico),
                        context.getResources().getDrawable(R.drawable.sunny_weather),
                        Constants.SUNNY_DAY_WEATHER);
            } else {
                pack = new ImagePack(context.getResources().getDrawable(R.drawable.clear_night_ico),
                        context.getResources().getDrawable(R.drawable.clear_night_weather),
                        Constants.CLEAR_NIGHT_WEATHER);
            }
        } else {
            switch (id) {
                case 2:
                    pack = new ImagePack(context.getResources().getDrawable(R.drawable.thunder_ico),
                            context.getResources().getDrawable(R.drawable.thunder_weather),
                            Constants.THUNDER_WEATHER);
                    break;
                case 3:
                    pack = new ImagePack(context.getResources().getDrawable(R.drawable.drizzle_ico),
                            context.getResources().getDrawable(R.drawable.drizzle_weather),
                            Constants.DRIZZLE_WEATHER);
                    break;
                case 7:
                    pack = new ImagePack(context.getResources().getDrawable(R.drawable.foggy_ico),
                            context.getResources().getDrawable(R.drawable.foggy_weather),
                            Constants.FOGGY_WEATHER);
                    break;
                case 8:
                    pack = new ImagePack(context.getResources().getDrawable(R.drawable.cloudy_ico),
                            context.getResources().getDrawable(R.drawable.cloudy_weather),
                            Constants.CLOUDY_WEATHER);
                    break;
                case 6:
                    pack = new ImagePack(context.getResources().getDrawable(R.drawable.snowy_ico),
                            context.getResources().getDrawable(R.drawable.snowy_weather),
                            Constants.SNOWY_WEATHER);
                    break;
                case 5:
                    pack = new ImagePack(context.getResources().getDrawable(R.drawable.rainy_ico),
                            context.getResources().getDrawable(R.drawable.rainy_weather),
                            Constants.RAINY_WEATHER);
                    break;
            }
        }
        return pack;
    }

}
