package com.yemeksepeti.interviewmvp.login;

/**
 * Created by farukyavuz on 01/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void setInternetConnectionError();

    void setLoginError();

    void navigateToHome();
}
