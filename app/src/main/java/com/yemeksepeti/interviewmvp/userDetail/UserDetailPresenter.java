package com.yemeksepeti.interviewmvp.userDetail;

/**
 * Created by farukyavuz on 02/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface UserDetailPresenter {

    void getUserDetail(String userId);

    void updateUserDetail(String userId, String email, String phone, String address);

    void onDestroy();
}
