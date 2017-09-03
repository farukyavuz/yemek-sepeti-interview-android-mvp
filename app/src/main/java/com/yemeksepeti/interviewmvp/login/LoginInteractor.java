package com.yemeksepeti.interviewmvp.login;

/**
 * Created by farukyavuz on 01/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();

        void onInternetConnectionError();

        void onLoginError();
    }

    void login(String email, String password, OnLoginFinishedListener listener);

}