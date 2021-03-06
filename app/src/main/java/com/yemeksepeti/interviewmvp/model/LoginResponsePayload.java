package com.yemeksepeti.interviewmvp.model;

import com.yemeksepeti.interviewmvp.model.common.User;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class LoginResponsePayload {
    private User user;

    public LoginResponsePayload() {
    }

    public LoginResponsePayload(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserListPayload{" +
                "user=" + user +
                '}';
    }
}
