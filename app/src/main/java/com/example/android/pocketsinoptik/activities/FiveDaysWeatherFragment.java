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
import com.example.android.pocketsinoptik.utils.DataKeeper;
import com.example.android.pocketsinoptik.widgets.adapters.FiveDaysContentAdapter;

/**
 * Created by fbrsw on 08.11.2017.
 */

public class FiveDaysWeatherFragment extends Fragment {

    private FiveDaysContentAdapter adapter;

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);

        DataKeeper dataKeeper = DataKeeper.getInstance();
        if (dataKeeper.getFiveDaysWeatherResponse() != null)
            adapter = new FiveDaysContentAdapter(recyclerView.getContext(), dataKeeper.getFiveDaysWeatherResponse().getList());
        else adapter = new FiveDaysContentAdapter(recyclerView.getContext(), null);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public void refreshInfo() {
        DataKeeper dataKeeper = DataKeeper.getInstance();
        if (dataKeeper.getFiveDaysWeatherResponse() != null)
            adapter.setList(dataKeeper.getFiveDaysWeatherResponse().getList());
        adapter.notifyDataSetChanged();
    }

}
