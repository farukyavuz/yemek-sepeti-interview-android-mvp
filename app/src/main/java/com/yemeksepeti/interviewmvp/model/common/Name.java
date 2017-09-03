package com.yemeksepeti.interviewmvp.model.common;

/**
 * Created by farukyavuz on 26/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class Name {
    private String last;
    private String first;

    public Name() {
    }

    public Name(String last, String first) {
        this.last = last;
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "Name{" +
                "last='" + last + '\'' +
                ", first='" + first + '\'' +
                '}';
    }
}
