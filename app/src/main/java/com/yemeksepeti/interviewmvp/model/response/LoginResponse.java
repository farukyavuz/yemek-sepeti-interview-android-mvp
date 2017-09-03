package com.yemeksepeti.interviewmvp.model.response;


import com.yemeksepeti.interviewmvp.model.LoginResponsePayload;
import com.yemeksepeti.interviewmvp.model.common.Status;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class LoginResponse {
    private boolean success;
    private Status status;
    private LoginResponsePayload payload;

    public LoginResponse() {
    }

    public LoginResponse(boolean success, Status status, LoginResponsePayload payload) {
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

    public LoginResponsePayload getPayload() {
        return payload;
    }

    public void setPayload(LoginResponsePayload payload) {
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
