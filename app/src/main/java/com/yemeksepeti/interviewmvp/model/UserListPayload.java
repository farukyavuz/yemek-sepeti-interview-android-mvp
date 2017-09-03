package com.yemeksepeti.interviewmvp.model;

import com.google.gson.annotations.SerializedName;
import com.yemeksepeti.interviewmvp.model.common.User;

import java.util.List;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserListPayload {

    @SerializedName("users")
    private List<User> userList;

    public UserListPayload() {
    }

    public UserListPayload(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserListPayload{" +
                "userList=" + userList +
                '}';
    }
}
