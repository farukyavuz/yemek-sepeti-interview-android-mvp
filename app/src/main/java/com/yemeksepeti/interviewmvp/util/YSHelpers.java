package com.yemeksepeti.interviewmvp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by farukyavuz on 26/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class YSHelpers {

    /**
     * Check Internet Connect
     *
     * @param context context
     * @return boolean true for connected false for not connected
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null &&
                networkInfo.isAvailable() &&
                networkInfo.isConnected();

    }

    @SuppressLint("SimpleDateFormat")
    public static String ConvertDateToString(String format, String date) {

        Date date1;
        date1 = stringToDate(date);
        Format formatter = new SimpleDateFormat(format);

        return formatter.format(date1);

    }

    /**
     * String to Date
     *
     * @param dateString date string
     * @return date
     */
    public static Date stringToDate(String dateString) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",new Locale("tr"));
            df.setTimeZone(TimeZone.getTimeZone("Etc/GMT-0"));
            return df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

}
