package com.yemeksepeti.interviewmvp.login;

/**
 * Created by farukyavuz on 01/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
