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
import com.example.android.pocketsinoptik.model.entities.five_days_weather.List;
import com.example.android.pocketsinoptik.utils.ImagePack;
import com.example.android.pocketsinoptik.utils.ImageSelector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fbrsw on 11.11.2017.
 */

public class FiveDaysContentAdapter extends RecyclerView.Adapter<FiveDaysContentAdapter.ViewHolder> {

    private Context context;

    private java.util.List<List> list = null;

    public FiveDaysContentAdapter(Context context, java.util.List<List> list) {
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
            long ms = list.get(position).getDt() * 1000;
            Date date = new Date(ms);
            String dayPart = (date.getHours() > 7 && date.getHours() < 19) ? Constants.DAY : Constants.NIGHT;
            ImagePack pack = ImageSelector.getImagePackById(context, list.get(position).getWeather().get(0).getId(), dayPart);
            holder.avator.setImageDrawable(pack.getIcon());
            holder.bg.setImageDrawable(pack.getBackGround());

            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.EXPAND_DATE_FORMAT, Locale.ENGLISH);

            holder.date.setText(dateFormat.format(date));
            holder.description.setText(pack.getDescription());

            double temp = list.get(position).getMain().getTemp();
            String temperature = String.valueOf((int) temp) + Constants.CELSIUS_ENDING;
            holder.temperature.setText(String.valueOf(temperature));

        } catch (Exception ignored) {
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

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avator;
        private ImageView bg;
        private TextView date;
        private TextView description;
        private TextView temperature;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_small_list, parent, false));
            avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            bg = (ImageView) itemView.findViewById(R.id.background_weather);
            date = (TextView) itemView.findViewById(R.id.list_title);
            description = (TextView) itemView.findViewById(R.id.list_desc);
            temperature = (TextView) itemView.findViewById(R.id.degree);

            itemView.setOnClickListener(v -> {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Constants.EXTRA_POSITION, getAdapterPosition());
                context.startActivity(intent);
            });
        }
    }
}
