package com.yemeksepeti.interviewmvp.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by farukyavuz on 14/03/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class YSharedPreferences {

    private final static String PREF = "YS_PREFERENCES";

    private final static String AUTH_TOKEN = "YS_AUTH_TOKEN";
    private final static String USERNAME = "YS_USERNAME";
    private final static String PASSWORD = "YS_PASSWORD";

    private static void setPreference(Context context, String key, Object value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof String){
            editor.putString(key, (String) value);
        } else if (value instanceof Integer){
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long){
            editor.putLong(key, (Long)value);
        } else if (value instanceof Float){
            editor.putFloat(key, (Float) value);
        }

        editor.apply();
    }

    public static Boolean isSessionActive(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return !sharedPreferences.getString(AUTH_TOKEN, "").equals("");
    }

    public static void clearSession(Context context){
        setPreference(context, AUTH_TOKEN, "");
        setPreference(context, USERNAME, "");
        setPreference(context, PASSWORD, "");
    }


    public static String getToken(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(AUTH_TOKEN, "");
    }

    public static void setToken(Context context, String token){
        setPreference(context, AUTH_TOKEN, token);
    }

    public static String getUsername(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USERNAME, "");
    }

    public static void setUsername(Context context, String token){
        setPreference(context, USERNAME, token);
    }

    public static String getPassword(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PASSWORD, "");
    }

    public static void setPassword(Context context, String token){
        setPreference(context, PASSWORD, token);
    }


}
