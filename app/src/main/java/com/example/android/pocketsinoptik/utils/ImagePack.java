package com.example.android.pocketsinoptik.utils;

import android.graphics.drawable.Drawable;

/**
 * Created by fbrsw on 11.11.2017.
 */

public class ImagePack {

    private Drawable icon;

    private Drawable backGround;

    private String description;

    public ImagePack(Drawable icon, Drawable backGround, String description) {
        this.icon = icon;
        this.backGround = backGround;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getBackGround() {
        return backGround;
    }

    public void setBackGround(Drawable backGround) {
        this.backGround = backGround;
    }
}
