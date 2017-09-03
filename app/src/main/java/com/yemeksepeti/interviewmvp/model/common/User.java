package com.yemeksepeti.interviewmvp.model.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukyavuz on 26/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class User {
    private String _id;
    private String password;
    private String email;
    private Name name;
    private String accessToken;
    private String accessTokenExpiration;
    private String address;
    private String phone;
    private String birthday;
    @SerializedName("image")
    private UserImage userImage;

    public User() {
    }

    public User(String _id, String password, String email, Name name, String accessToken, String accessTokenExpiration, String address, String phone, String birthday, UserImage userImage) {
        this._id = _id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.accessToken = accessToken;
        this.accessTokenExpiration = accessTokenExpiration;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.userImage = userImage;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenExpiration() {
        return accessTokenExpiration;
    }

    public void setAccessTokenExpiration(String accessTokenExpiration) {
        this.accessTokenExpiration = accessTokenExpiration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public UserImage getUserImage() {
        return userImage;
    }

    public void setUserImage(UserImage userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpiration='" + accessTokenExpiration + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", userImage=" + userImage +
                '}';
    }
}
