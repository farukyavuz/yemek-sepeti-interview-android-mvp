package com.yemeksepeti.interviewmvp.model.common;

/**
 * Created by farukyavuz on 26/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserImage {
    private String url;

    public UserImage() {
    }

    public UserImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UserImage{" +
                "url='" + url + '\'' +
                '}';
    }
}
