package com.example.android.pocketsinoptik.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.pocketsinoptik.R;
import com.example.android.pocketsinoptik.utils.DataKeeper;
import com.example.android.pocketsinoptik.widgets.adapters.SixteenDaysContentAdapter;

/**
 * Created by fbrsw on 08.11.2017.
 */

public class SixteenDaysWeatherFragment extends Fragment {

    private SixteenDaysContentAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        Toast.makeText(recyclerView.getContext(), "rebuild", Toast.LENGTH_LONG).show();

        DataKeeper dataKeeper = DataKeeper.getInstance();
        if (dataKeeper.getSixteenDaysWeatherResponse() != null)
            adapter = new SixteenDaysContentAdapter(recyclerView.getContext(), dataKeeper.getSixteenDaysWeatherResponse().getList());
        else adapter = new SixteenDaysContentAdapter(recyclerView.getContext(), null);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public void refreshInfo() {
        DataKeeper dataKeeper = DataKeeper.getInstance();
        if (dataKeeper.getSixteenDaysWeatherResponse() != null)
            adapter.setList(dataKeeper.getSixteenDaysWeatherResponse().getList());
        adapter.notifyDataSetChanged();
    }

}
