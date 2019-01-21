package com.homay.just.meeter;

public interface BaseCredentialInterface {

    void onLogin(String username, String password);
    void onSignUp(String username, String password);

    void onLoginWithFacebook();
    void onLoginWithGoogle();
}
