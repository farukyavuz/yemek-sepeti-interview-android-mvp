package com.yemeksepeti.interviewmvp.login;

/**
 * Created by farukyavuz on 01/09/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    @Override
    public void onInternetConnectionError() {
        if (loginView != null) {
            loginView.setInternetConnectionError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onLoginError() {
        if (loginView != null) {
            loginView.setLoginError();
            loginView.hideProgress();
        }
    }
}