package com.yemeksepeti.interviewmvp.model.response;


import com.yemeksepeti.interviewmvp.model.common.Status;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class DefaultResponse {
    private boolean success;
    private Status status;

    public DefaultResponse() {
    }

    public DefaultResponse(boolean success, Status status) {
        this.success = success;
        this.status = status;
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

    @Override
    public String toString() {
        return "LoginResponse{" +
                "success=" + success +
                ", status=" + status +
                '}';
    }
}
