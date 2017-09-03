package com.yemeksepeti.interviewmvp.userList;

import com.yemeksepeti.interviewmvp.model.common.User;

import java.util.List;

/**
 * Created by farukyavuz on 02/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserListPresenterImpl implements UserListPresenter, UserListInteractor.OnUserListListener{

    private UserListView userListView;
    private UserListInteractor userListInteractor;


    public UserListPresenterImpl(UserListView userListView) {
        this.userListView = userListView;
        this.userListInteractor = new UserListInteractorImpl();
    }

    @Override
    public void getUsetList() {
        if (userListView != null) {
            userListView.showProgress();
        }
        userListInteractor.getUsers(this);
    }

    @Override
    public void onDestroy() {
        userListView = null;
    }

    @Override
    public void onTokenError() {
        if (userListView != null) {
            userListView.hideProgress();
            userListView.setTokenError();
        }
    }

    @Override
    public void onSuccess(List<User> userList) {
        if (userListView != null) {
            userListView.hideProgress();
            userListView.updateList(userList);
        }
    }

    @Override
    public void onInternetConnectionError() {
        if (userListView != null) {
            userListView.hideProgress();
            userListView.setInternetConnectionError();
        }
    }
}
