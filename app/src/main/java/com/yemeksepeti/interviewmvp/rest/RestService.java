package com.yemeksepeti.interviewmvp.rest;



import com.yemeksepeti.interviewmvp.model.request.LoginRequest;
import com.yemeksepeti.interviewmvp.model.request.UserUpdateRequest;
import com.yemeksepeti.interviewmvp.model.response.DefaultResponse;
import com.yemeksepeti.interviewmvp.model.response.LoginResponse;
import com.yemeksepeti.interviewmvp.model.response.UserListResponse;
import com.yemeksepeti.interviewmvp.model.response.UserResponse;
import com.yemeksepeti.interviewmvp.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public interface RestService {

    @POST(Constants.ENDPOINT_LOGIN)
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET(Constants.ENDPOINT_USERS)
    Call<UserListResponse> users(@Header("x-access-token") String accessToken, @Header("x-key") String xKey);

    @GET(Constants.ENDPOINT_USER)
    Call<UserResponse> user(@Header("x-access-token") String accessToken, @Header("x-key") String xKey, @Path("userId") String userId);

    @POST(Constants.ENDPOINT_USER_UPDATE)
    Call<DefaultResponse> userUpdate(@Header("x-access-token") String accessToken, @Header("x-key") String xKey, @Body UserUpdateRequest userUpdateRequest);

}
