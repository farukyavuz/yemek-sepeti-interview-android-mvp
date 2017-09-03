package com.yemeksepeti.interviewmvp.model.response;

import com.yemeksepeti.interviewmvp.model.UserListPayload;
import com.yemeksepeti.interviewmvp.model.common.Status;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserListResponse {
    private boolean success;
    private Status status;
    private UserListPayload payload;

    public UserListResponse() {
    }

    public UserListResponse(boolean success, Status status, UserListPayload payload) {
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

    public UserListPayload getPayload() {
        return payload;
    }

    public void setPayload(UserListPayload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "UserListResponse{" +
                "success=" + success +
                ", status=" + status +
                ", payload=" + payload +
                '}';
    }
}
