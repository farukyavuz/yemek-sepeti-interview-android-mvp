package com.yemeksepeti.interviewmvp.userDetail;

import com.yemeksepeti.interviewmvp.model.common.User;

/**
 * Created by farukyavuz on 02/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface UserDetailView {

    void showProgress();

    void hideProgress();

    void setEmailError();

    void setPhoneNumberError();

    void setInternetConnectionError();

    void setTokenError();

    void userUpdated();

    void getUser(User user);

}
