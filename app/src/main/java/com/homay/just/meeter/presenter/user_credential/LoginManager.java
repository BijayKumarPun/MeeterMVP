package com.homay.just.meeter.presenter.user_credential;


import android.util.Log;

import com.homay.just.meeter.db.firebase_helper.FirebaseLoginCallbacks;
import com.homay.just.meeter.db.firebase_helper.FirebaseLoginHandler;
import com.homay.just.meeter.ui.splash.StartupActivityCallback;

public class LoginManager implements StartupActivityCallback, FirebaseLoginCallbacks {
    private String TAG = "LoginManager";

LoginManagerCallback loginManagerCallback;
FirebaseLoginHandler firebaseLoginHandler;

    public LoginManager() {
firebaseLoginHandler = new FirebaseLoginHandler();
this.loginManagerCallback = firebaseLoginHandler;
        firebaseLoginHandler.setFirebaseLoginCallbacks(this);
    }


    @Override
    public void onLogin(String username, String password) {
        Log.i(TAG, "onLogin:");
        loginManagerCallback.onLogin(username,password);

    }

    @Override
    public void onSignUp(String username, String password) {
        Log.i(TAG, "onSignUp: ");
loginManagerCallback.onSignUp(username,password);
    }

    @Override
    public void onLoginWithFacebook() {
        Log.i(TAG, "onLoginWithFacebook: ");
        loginManagerCallback.onLoginWithFacebook();
    }

    @Override
    public void onLoginWithGoogle() {
        Log.i(TAG, "onLoginWithGoogle: ");
        loginManagerCallback.onLoginWithGoogle();

    }


    //FirebaseLoginCallbacks
    @Override
    public void onLoginSuccess() {
        Log.i(TAG, "onLoginSuccess: ");
    }

    @Override
    public void onLoginFailed() {
        Log.i(TAG, "onLoginFailed: ");
    }

    @Override
    public void onSignUpSuccess() {
        Log.i(TAG, "onSignUpSuccess: ");
    }

    @Override
    public void onSignUpFailed() {
        Log.i(TAG, "onSignUpFailed: ");
    }


}

