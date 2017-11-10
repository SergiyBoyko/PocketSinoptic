package com.example.android.pocketsinoptik.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.android.pocketsinoptik.di.module.ApiModule;
import com.example.android.pocketsinoptik.di.module.AppModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fbrsw on 10.11.2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class
})
public interface AppComponent {

    Context context();

    SharedPreferences preferences();

    Executor executor();

}
