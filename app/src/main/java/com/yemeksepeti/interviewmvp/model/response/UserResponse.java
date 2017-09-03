package com.yemeksepeti.interviewmvp.model.response;


import com.yemeksepeti.interviewmvp.model.UserPayload;
import com.yemeksepeti.interviewmvp.model.common.Status;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserResponse {
    private boolean success;
    private Status status;
    private UserPayload payload;

    public UserResponse() {
    }

    public UserResponse(boolean success, Status status, UserPayload payload) {
        this.success = success;
        this.status = status;
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserPayload getPayload() {
        return payload;
    }

    public void setPayload(UserPayload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "success=" + success +
                ", status=" + status +
                ", payload=" + payload +
                '}';
    }
}
