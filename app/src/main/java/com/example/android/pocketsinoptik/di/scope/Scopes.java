package com.example.android.pocketsinoptik.di.scope;

/**
 * Created by fbrsw on 09.11.2017.
 * Constants variables for modules and providers.
 */

public class Scopes {

    /**
     * Lifecycle scope annotation constants.
     */
    public static final String ACTIVITY = "activity";
    public static final String SERVICE = "service";
    public static final String FRAGMENT = "fragment";
    public static final String VIEW = "view";

    private Scopes() {
        throw new AssertionError("Unable to instantiate");
    }

}
