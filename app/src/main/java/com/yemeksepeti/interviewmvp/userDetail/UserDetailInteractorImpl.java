package com.yemeksepeti.interviewmvp.userDetail;

import android.text.TextUtils;
import android.util.Patterns;

import com.yemeksepeti.interviewmvp.YSApplication;
import com.yemeksepeti.interviewmvp.model.request.UserUpdateRequest;
import com.yemeksepeti.interviewmvp.model.response.DefaultResponse;
import com.yemeksepeti.interviewmvp.model.response.UserResponse;
import com.yemeksepeti.interviewmvp.util.YSHelpers;
import com.yemeksepeti.interviewmvp.util.YSharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by farukyavuz on 01/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserDetailInteractorImpl implements UserDetailInteractor {

    @Override
    public void updateUser(final String userId, final String email, final String phone,
                           final String address, final OnUserDetailListener listener) {

        boolean error = false;

        if (!YSHelpers.isConnected(YSApplication.getAppContext())) {
            listener.onInternetConnectionError();
            error = true;
            return;
        }

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            listener.onEmailError();
            error = true;
            return;
        }
        if (TextUtils.isEmpty(phone) || !Patterns.PHONE.matcher(phone).matches()) {
            listener.onPhoneNumberError();
            error = true;
            return;
        }

        if (!error) {

            UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
            userUpdateRequest.setUserId(userId);
            userUpdateRequest.setPhone(phone);
            userUpdateRequest.setEmail(email);
            userUpdateRequest.setAddress(address);

            Call<DefaultResponse> call = YSApplication.getRestService().userUpdate(
                    YSharedPreferences.getToken(YSApplication.getAppContext()), YSharedPreferences.getUsername(YSApplication.getAppContext()), userUpdateRequest);

            call.enqueue(new Callback<DefaultResponse>() {
                @Override
                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                    DefaultResponse defaultResponse = response.body();
                    if (defaultResponse.isSuccess()) {
                        listener.onUserUpdated();
                    } else {
                        listener.onTokenError();
                    }
                }

                @Override
                public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    //TODO
                }
            });
        }
    }

    @Override
    public void getUser(String userId, final OnUserDetailListener listener) {

        boolean error = false;

        if (!YSHelpers.isConnected(YSApplication.getAppContext())) {
            listener.onInternetConnectionError();
            error = true;
            return;
        }

        if (!error) {

            Call<UserResponse> call = YSApplication.getRestService().user(
                    YSharedPreferences.getToken(YSApplication.getAppContext())
                    , YSharedPreferences.getUsername(YSApplication.getAppContext()), userId);

            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    UserResponse userResponse = response.body();
                    if (userResponse.isSuccess()) {
                        listener.onGetUser(userResponse.getPayload().getUser());
                    } else {
                        listener.onTokenError();
                    }
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    //TODO
                }
            });
        }
    }
}
