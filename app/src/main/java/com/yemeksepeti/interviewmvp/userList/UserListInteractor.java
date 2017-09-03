package com.yemeksepeti.interviewmvp.userList;

import com.yemeksepeti.interviewmvp.model.common.User;

import java.util.List;

/**
 * Created by farukyavuz on 02/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface UserListInteractor {

    interface OnUserListListener {
        void onTokenError();

        void onSuccess(List<User> userList);

        void onInternetConnectionError();
    }

    void getUsers(OnUserListListener listener);
}
