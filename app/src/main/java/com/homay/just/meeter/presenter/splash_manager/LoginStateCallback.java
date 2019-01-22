package com.homay.just.meeter.presenter.splash_manager;

public interface LoginStateCallback {
    void onLoginSuccess(String message);
    void onLoginFailed(String message);

    void onSignUpSuccess(String message);
    void onSignUpFailed(String message);
}
