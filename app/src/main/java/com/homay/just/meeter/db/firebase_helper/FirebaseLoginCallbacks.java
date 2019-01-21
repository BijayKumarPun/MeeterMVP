package com.homay.just.meeter.db.firebase_helper;

public interface FirebaseLoginCallbacks {

    void onLoginSuccess();
    void onLoginFailed();

    void onSignUpSuccess();
    void onSignUpFailed();
}
