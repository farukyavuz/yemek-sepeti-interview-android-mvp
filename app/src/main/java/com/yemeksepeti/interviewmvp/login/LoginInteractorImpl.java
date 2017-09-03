package com.yemeksepeti.interviewmvp.login;

import android.text.TextUtils;
import android.util.Patterns;

import com.yemeksepeti.interviewmvp.YSApplication;
import com.yemeksepeti.interviewmvp.model.request.LoginRequest;
import com.yemeksepeti.interviewmvp.model.response.LoginResponse;
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

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String email, final String password, final OnLoginFinishedListener listener) {

        boolean error = false;

        if (!YSHelpers.isConnected(YSApplication.getAppContext())) {
            listener.onInternetConnectionError();
            error = true;
            return;
        }

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            listener.onUsernameError();
            error = true;
            return;
        }
        if (TextUtils.isEmpty(password) || password.length() < 6 || password.length() > 10) {
            listener.onPasswordError();
            error = true;
            return;
        }
        if (!error) {

            final LoginRequest loginRequest = new LoginRequest(email, password);

            Call<LoginResponse> call = YSApplication.getRestService().login(loginRequest);

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.isSuccess()) {
                        YSharedPreferences.setToken(YSApplication.getAppContext(), loginResponse.getPayload().getUser().getAccessToken());
                        YSharedPreferences.setUsername(YSApplication.getAppContext(), loginRequest.getEmail());
                        YSharedPreferences.setPassword(YSApplication.getAppContext(), loginRequest.getPassword());
                        listener.onSuccess();
                    } else {
                        listener.onLoginError();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    listener.onLoginError();
                }
            });
        }
    }
}
