package com.homay.just.meeter.presenter.user_credential;

public interface LoginStateCallback {
    void onLoginSuccess(String message);
    void onLoginFailed(String message);

    void onSignUpSuccess(String message);
    void onSignUpFailed(String message);
}
