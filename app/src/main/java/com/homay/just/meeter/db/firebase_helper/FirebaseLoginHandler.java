package com.homay.just.meeter.db.firebase_helper;

import android.util.Log;

import com.homay.just.meeter.presenter.splash_manager.LoginManagerCallback;

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
        signUpUser(username, password);
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
    //TODO Do the login stuff here and send back the result

        Log.i(TAG, "loginUser: Successful");
        firebaseLoginCallbacks.onLoginSuccess("This is a message from onLoginSuccess");

    }

    private void signUpUser(String username, String password){
    //TODO Do the signup stuff here and send back the result

    firebaseLoginCallbacks.onSignUpFailed("This is a message from onSignUpFailed");

    }

    public void setFirebaseLoginCallbacks(FirebaseLoginCallbacks firebaseLoginCallbacks) {
    this.firebaseLoginCallbacks = firebaseLoginCallbacks;
    }

}
