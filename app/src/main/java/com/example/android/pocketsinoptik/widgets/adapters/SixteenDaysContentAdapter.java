package com.example.android.pocketsinoptik.widgets.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.R;
import com.example.android.pocketsinoptik.activities.DetailActivity;
import com.example.android.pocketsinoptik.model.entities.sixteen_days_weather.List;
import com.example.android.pocketsinoptik.utils.ImagePack;
import com.example.android.pocketsinoptik.utils.ImageSelector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fbrsw on 11.11.2017.
 */

public class SixteenDaysContentAdapter extends RecyclerView.Adapter<SixteenDaysContentAdapter.ViewHolder> {

    private Context context;

    private java.util.List<List> list = null;

    public SixteenDaysContentAdapter(Context context, java.util.List<List> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            ImagePack pack = ImageSelector.getImagePackById(context, list.get(position).getWeather().get(0).getId(), Constants.DAY);
            holder.avator.setImageDrawable(pack.getIcon());
            holder.bg.setImageDrawable(pack.getBackGround());

            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.ENGLISH);
            long ms = list.get(position).getDt() * 1000;

            holder.name.setText(dateFormat.format(new Date(ms)));
            holder.description.setText(pack.getDescription());

            double temp = list.get(position).getTemp().getDay();
            String temperature = String.valueOf((int) temp) + Constants.CELSIUS_ENDING;
            holder.temperature.setText(String.valueOf(temperature));

            temp = list.get(position).getTemp().getMax();
            temperature = "max " + String.valueOf((int) temp) + Constants.CELSIUS_ENDING;
            holder.maxTemperature.setText(String.valueOf(temperature));

            temp = list.get(position).getTemp().getMin();
            temperature = "min " +  String.valueOf((int) temp) + Constants.CELSIUS_ENDING;
            holder.minTemperature.setText(String.valueOf(temperature));

        } catch (Exception e) {
            holder.avator.setImageDrawable(context.getResources().getDrawable(R.drawable.na));
            holder.bg.setImageDrawable(context.getResources().getDrawable(R.drawable.na));
            holder.name.setText(context.getString(R.string.adapter_error));
            holder.description.setText(context.getString(R.string.adapter_error));
        }
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avator;
        public ImageView bg;
        public TextView name;
        public TextView description;
        public TextView temperature;
        public TextView maxTemperature;
        public TextView minTemperature;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_large_list, parent, false));
            avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            bg = (ImageView) itemView.findViewById(R.id.background_weather);
            name = (TextView) itemView.findViewById(R.id.list_title);
            description = (TextView) itemView.findViewById(R.id.list_desc);
            temperature = (TextView) itemView.findViewById(R.id.degree);
            maxTemperature = (TextView) itemView.findViewById(R.id.max_temperature);
            minTemperature = (TextView) itemView.findViewById(R.id.min_temperature);

            itemView.setOnClickListener(v -> {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Constants.EXTRA_POSITION, getAdapterPosition());
                context.startActivity(intent);
            });
        }
    }
}
