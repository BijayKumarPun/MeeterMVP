package com.homay.just.meeter.presenter.user_credential;


import android.util.Log;

import com.homay.just.meeter.db.firebase_helper.FirebaseLoginCallbacks;
import com.homay.just.meeter.db.firebase_helper.FirebaseLoginHandler;
import com.homay.just.meeter.presenter.MainPresenter;
import com.homay.just.meeter.presenter.MainPresenterInterface;
import com.homay.just.meeter.presenter.activity.starter.StartupActivityCallback;

public class LoginManager implements StartupActivityCallback, FirebaseLoginCallbacks {
    private String TAG = "LoginManager";

private LoginManagerCallback loginManagerCallback;
FirebaseLoginHandler firebaseLoginHandler;



    //LoginState callback
    LoginStateCallback loginStateCallback;

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
    public void onLoginSuccess(String message) {
        Log.i(TAG, "onLoginSuccess: "+ message);

        loginStateCallback.onLoginSuccess(message);
    }

    @Override
    public void onLoginFailed(String message) {
        Log.i(TAG, "onLoginFailed: "+message);
        loginStateCallback.onLoginFailed(message);
    }

    @Override
    public void onSignUpSuccess(String message) {
        Log.i(TAG, "onSignUpSuccess: "+message);
        loginStateCallback.onSignUpSuccess(message);
    }

    @Override
    public void onSignUpFailed(String message) {
        Log.i(TAG, "onSignUpFailed: "+message);
        loginStateCallback.onSignUpFailed(message);
    }

    //set LoginState callback
    public void setloginStateCallback(LoginStateCallback loginStateCallback) {
        this.loginStateCallback = loginStateCallback;
    }

}

