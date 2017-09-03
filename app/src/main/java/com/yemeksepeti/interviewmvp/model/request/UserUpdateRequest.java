package com.yemeksepeti.interviewmvp.model.request;

/**
 * Created by farukyavuz on 29/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserUpdateRequest {
    private String userId;
    private String email;
    private String phone;
    private String address;

    public UserUpdateRequest() {
    }

    public UserUpdateRequest(String userId, String email, String phone, String address) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserUpdateRequest{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
