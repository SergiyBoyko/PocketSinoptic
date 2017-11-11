package com.example.android.pocketsinoptik.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pocketsinoptik.Constants;
import com.example.android.pocketsinoptik.R;

/**
 * Created by fbrsw on 08.11.2017.
 */

public class ListContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avator;
        public ImageView bg;
        public TextView name;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_small_list, parent, false));
            avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            bg = (ImageView) itemView.findViewById(R.id.background_weather);
            name = (TextView) itemView.findViewById(R.id.list_title);
            description = (TextView) itemView.findViewById(R.id.list_desc);
            itemView.setOnClickListener(v -> {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Constants.EXTRA_POSITION, getAdapterPosition());
                context.startActivity(intent);
            });
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        private final String[] mPlaces;
        private final String[] mPlaceDesc;
        private final Drawable[] mPlaceAvators;
        private final Drawable[] mPlaceBgs;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.places);
            mPlaceDesc = resources.getStringArray(R.array.place_desc);
            TypedArray a = resources.obtainTypedArray(R.array.place_avator);
            mPlaceAvators = new Drawable[a.length()];
            for (int i = 0; i < mPlaceAvators.length; i++) {
                mPlaceAvators[i] = a.getDrawable(i);
            }

            TypedArray b = resources.obtainTypedArray(R.array.places_picture);
            mPlaceBgs = new Drawable[b.length()];
            for (int i = 0; i < mPlaceAvators.length; i++) {
                mPlaceBgs[i] = b.getDrawable(i);
            }

            a.recycle();
            b.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.avator.setImageDrawable(mPlaceAvators[position % mPlaceAvators.length]);
            holder.bg.setImageDrawable(mPlaceBgs[position % mPlaceBgs.length]);
            holder.name.setText(mPlaces[position % mPlaces.length]);
            holder.description.setText(mPlaceDesc[position % mPlaceDesc.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
