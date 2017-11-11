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

/**
 * Created by fbrsw on 08.11.2017.
 */

public class CardContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_card, null);
        view.findViewById(R.id.frame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Constants.EXTRA_POSITION, 0);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
