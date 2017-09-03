package com.yemeksepeti.interviewmvp.userList;

import com.yemeksepeti.interviewmvp.YSApplication;
import com.yemeksepeti.interviewmvp.model.response.UserListResponse;
import com.yemeksepeti.interviewmvp.util.YSHelpers;
import com.yemeksepeti.interviewmvp.util.YSharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by farukyavuz on 02/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserListInteractorImpl implements UserListInteractor {

    @Override
    public void getUsers(final OnUserListListener listener) {

        if (!YSHelpers.isConnected(YSApplication.getAppContext())) {
            listener.onInternetConnectionError();
            return;
        }

        Call<UserListResponse> call = YSApplication
                .getRestService().users(YSharedPreferences.getToken(YSApplication.getAppContext()), YSharedPreferences.getUsername(YSApplication.getAppContext()));

        call.enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                UserListResponse userListResponse = response.body();
                if (userListResponse.isSuccess()) {
                    listener.onSuccess(userListResponse.getPayload().getUserList());
                } else {
                    listener.onTokenError();
                }
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable t) {
                listener.onInternetConnectionError();
            }
        });


    }
}
