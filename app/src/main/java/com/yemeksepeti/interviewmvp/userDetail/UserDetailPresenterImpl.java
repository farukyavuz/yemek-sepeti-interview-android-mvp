package com.yemeksepeti.interviewmvp.userDetail;

import com.yemeksepeti.interviewmvp.model.common.User;

/**
 * Created by farukyavuz on 03/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserDetailPresenterImpl implements UserDetailPresenter, UserDetailInteractor.OnUserDetailListener {

    private UserDetailView userDetailView;
    private UserDetailInteractor userDetailInteractor;

    public UserDetailPresenterImpl(UserDetailView userDetailView) {
        this.userDetailView = userDetailView;
        this.userDetailInteractor = new UserDetailInteractorImpl();
    }

    @Override
    public void getUserDetail(String userId) {
        if (userDetailView != null) {
            userDetailView.showProgress();
        }
        userDetailInteractor.getUser(userId, this);
    }

    @Override
    public void updateUserDetail(String userId, String email, String phone, String address) {
        if (userDetailView != null) {
            userDetailView.showProgress();
        }
        userDetailInteractor.updateUser(userId, email, phone, address, this);
    }

    @Override
    public void onDestroy() {
        userDetailView = null;
    }

    @Override
    public void onEmailError() {
        if (userDetailView != null) {
            userDetailView.setEmailError();
            userDetailView.hideProgress();
        }
    }

    @Override
    public void onPhoneNumberError() {
        if (userDetailView != null) {
            userDetailView.setPhoneNumberError();
            userDetailView.hideProgress();
        }
    }

    @Override
    public void onInternetConnectionError() {
        if (userDetailView != null) {
            userDetailView.setInternetConnectionError();
            userDetailView.hideProgress();
        }
    }

    @Override
    public void onTokenError() {
        if (userDetailView != null) {
            userDetailView.setTokenError();
            userDetailView.hideProgress();
        }
    }

    @Override
    public void onUserUpdated() {
        if (userDetailView != null) {
            userDetailView.userUpdated();
            userDetailView.hideProgress();
        }
    }

    @Override
    public void onGetUser(User user) {
        if (userDetailView != null) {
            userDetailView.getUser(user);
            userDetailView.hideProgress();
        }
    }
}
