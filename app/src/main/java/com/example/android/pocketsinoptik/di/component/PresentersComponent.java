package com.example.android.pocketsinoptik.di.component;

import com.example.android.pocketsinoptik.activities.MainActivity;
import com.example.android.pocketsinoptik.di.module.PresentersModule;
import com.example.android.pocketsinoptik.di.scope.Scope;
import com.example.android.pocketsinoptik.di.scope.Scopes;

import dagger.Component;

/**
 * Created by fbrsw on 10.11.2017.
 */

@Scope(Scopes.VIEW)
@Component(
        modules = {PresentersModule.class},
        dependencies = {AppComponent.class}
)
public interface PresentersComponent {

    void inject(MainActivity weatherView);

}
