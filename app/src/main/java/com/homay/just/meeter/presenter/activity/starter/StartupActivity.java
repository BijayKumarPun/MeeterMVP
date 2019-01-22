package com.homay.just.meeter.presenter.activity.starter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.homay.just.meeter.R;

import com.homay.just.meeter.presenter.MainPresenter;
import com.homay.just.meeter.presenter.MainPresenterInterface;
import com.homay.just.meeter.presenter.splash_manager.LoginManager;
import com.homay.just.meeter.presenter.splash_manager.LoginStateCallback;
import com.homay.just.meeter.ui.splash.FragmentLogin;
import com.homay.just.meeter.ui.splash.FragmentSignUp;
import com.homay.just.meeter.ui.splash.SplashFragmentCallback;

public class StartupActivity extends AppCompatActivity implements SplashFragmentCallback,LoginStateCallback {
    FrameLayout frameLayoutContainer;
    FragmentManager fragmentManager;
    FragmentLogin fragmentLogin;


    //LoginManager
    LoginManager loginManager;
    LoginStateCallback loginStateCallback;
    StartupActivityCallback startupActivityCallback;

    //MainPresenter
    MainPresenter mainPresenter;
    MainPresenterInterface mainPresenterInterface;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_main);
        //Use LoginManager to manage logins and signups


        frameLayoutContainer = findViewById(R.id.frameLayout_container_);
        fragmentManager = getSupportFragmentManager();

        //FragmentSignup
        fragmentLogin = new FragmentLogin();


        //show sign in screen;
        displaySignInMenu();

        //LoginManager
        loginManager = new LoginManager();
       loginManager.setloginStateCallback(this);

        //set callbacks on StartupActivityCallback
        startupActivityCallback = loginManager;

        //MainPresenter
        mainPresenter = new MainPresenter();
        mainPresenterInterface = mainPresenter;



    }

    private void displaySignInMenu() {
        fragmentManager.beginTransaction().replace(R.id.frameLayout_container_, fragmentLogin, "Fragment Login").commit();

    }

    @Override
    public void onLogin(String username, String password) {
        startupActivityCallback.onLogin(username, password);
    }

    @Override
    public void onLoginWithFacebook() {
        startupActivityCallback.onLoginWithFacebook();
    }

    @Override
    public void onLoginWithGoogle() {
        startupActivityCallback.onLoginWithGoogle();
    }

    @Override
    public void onRegister() {
        Toast.makeText(this, "Registration", Toast.LENGTH_SHORT).show();
        fragmentManager.beginTransaction().add(R.id.frameLayout_container_, new FragmentSignUp(), "Fragment SignUp").addToBackStack("Fragment SignUp").commit();

    }

    @Override
    public void onSignUp(String username, String password) {
        startupActivityCallback.onSignUp(username, password);
    }

    @Override
    public void onSignIn() {
        displaySignInMenu();
    }



    //Login state callbacks

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, " "+message, Toast.LENGTH_SHORT).show();
        mainPresenterInterface.startHomeActivity(this);
    }

    @Override
    public void onLoginFailed(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSignUpFailed(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();


    }
}
