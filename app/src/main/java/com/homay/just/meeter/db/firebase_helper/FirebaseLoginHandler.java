package com.homay.just.meeter.db.firebase_helper;

import android.util.Log;

import com.homay.just.meeter.presenter.user_credential.LoginManagerCallback;

public class FirebaseLoginHandler implements LoginManagerCallback {
    private String TAG = "FirebaseLoginHadler";

    FirebaseLoginCallbacks firebaseLoginCallbacks;

public FirebaseLoginHandler() {

}

    @Override
    public void onLogin(String username, String password) {
        Log.i(TAG, "onLogin: ");

        loginUser();

    }

    @Override
    public void onSignUp(String username, String password) {
        Log.i(TAG, "onSignUp: ");
    }

    @Override
    public void onLoginWithFacebook() {
        Log.i(TAG, "onLoginWithFacebook: ");
    }

    @Override
    public void onLoginWithGoogle() {
        Log.i(TAG, "onLoginWithGoogle: ");
    }

    private void loginUser() {
        Log.i(TAG, "loginUser: Successful");
        firebaseLoginCallbacks.onLoginSuccess();

    }

    public void setFirebaseLoginCallbacks(FirebaseLoginCallbacks firebaseLoginCallbacks) {
    this.firebaseLoginCallbacks = firebaseLoginCallbacks;
    }

}
