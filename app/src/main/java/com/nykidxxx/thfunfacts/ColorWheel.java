package com.nykidxxx.thfunfacts;

import android.graphics.Color;

import java.util.Random;

// Created on 3/28/2017
public class ColorWheel {

    // Fields
    private final String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };
    // Methods
    public int getColor(){
        String color;
        Random rng = new Random();
        int randomNumber = rng.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);


        return colorAsInt;
    }
}
