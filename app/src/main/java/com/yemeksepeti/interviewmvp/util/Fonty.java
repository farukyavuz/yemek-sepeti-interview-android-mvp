package com.yemeksepeti.interviewmvp.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/*
 ******************************************************************************
 *
 * Created by farukyavuz on 8.06.2017
 *
 * Licensed under the Apache License 2.0
 *
 ******************************************************************************
 *
 * @author Faruk Yavuz <faruk@email.com>
 *
 ******************************************************************************
 */

public class Fonty {

    private static Map<String, Typeface> fontMap;

    public static void builder(Context context) {
        fontMap = new HashMap<>();
        try {
            String[] fontsAsset = context.getAssets().list("fonts");
            for (String font : fontsAsset) {
                fontMap.put(font.split(Pattern.quote("."))[0].toLowerCase(), Typeface.createFromAsset(context.getAssets(), "fonts/" + font));
            }
            Log.d("Fonty : ", "Running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Fonty() {
    }

    /**
     * Set custom font to all of the views recursively
     *
     * @param parent parent view
     */
    public static void setFontAllView(ViewGroup parent) {
        if (parent == null) return;
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                setFontAllView((ViewGroup) child);
            } else if (child != null) {
                setFontView(child);
            }
        }
    }

    /**
     * Set custom font to view
     *
     * Button, ToogleButton CheckBox, RadioButton, EditText, Switch extended TextView
     *
     * @param child view
     */
    public static void setFontView(View child) {
        if (child == null) return;
        Typeface face;
        if (child.getTag() != null && fontMap.containsKey(child.getTag().toString().toLowerCase())) {
            face = fontMap.get(child.getTag().toString().toLowerCase());
        }
        else {
            face = Typeface.DEFAULT;
        }
        if (child instanceof TextView) {
            TextView textView = (TextView) child;
            textView.setTypeface(face);
        }
    }
}