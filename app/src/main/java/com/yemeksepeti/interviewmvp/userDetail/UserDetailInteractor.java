package com.yemeksepeti.interviewmvp.userDetail;

import com.yemeksepeti.interviewmvp.model.common.User;

/**
 * Created by farukyavuz on 01/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface UserDetailInteractor {

    interface OnUserDetailListener {
        void onEmailError();

        void onPhoneNumberError();

        void onInternetConnectionError();

        void onTokenError();

        void onUserUpdated();

        void onGetUser(User user);
    }

    void getUser(String userId, OnUserDetailListener listener);

    void updateUser(String userId, String email, String phone, String address, OnUserDetailListener listener);

}