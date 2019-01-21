package com.homay.just.meeter.ui.splash;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.homay.just.meeter.R;

public class FragmentLogin extends Fragment implements View.OnClickListener {
    Button login, login_google, login_facebook;
    TextView textViewRegisterOption;
    SplashFragmentCallback splashFragmentCallback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View loginView = inflater.inflate(R.layout.fragment_login, container, false);

        //instantiate
        login = loginView.findViewById(R.id.button_login);
        login_google = loginView.findViewById(R.id.button_google_login);
        login_facebook = loginView.findViewById(R.id.button_facebook_login);
        textViewRegisterOption = loginView.findViewById(R.id.textview_option_register);

        //set click listeners
        login.setOnClickListener(this);
        login_google.setOnClickListener(this);
        login_facebook.setOnClickListener(this);
        textViewRegisterOption.setOnClickListener(this);

        return loginView;
    }

    //set listener


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SplashFragmentCallback) {
            this.splashFragmentCallback = ((SplashFragmentCallback) context);
        }
        else {
            throw new RuntimeException("SplashFragmentCallback is not implemented");
        }
    }

    //handle clicks
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                loginUser();
                break;

            case R.id.button_google_login:
                loginUserWithGoogle();
                break;

            case R.id.button_facebook_login:
                loginUserWithFacebook();
                break;

            case R.id.textview_option_register:
                registerUser();
            default:
                // do some default stuff
        }
    }

    private void registerUser() {
        splashFragmentCallback.onRegister();
    }

    private void loginUserWithFacebook() {
        splashFragmentCallback.onLoginWithFacebook();
    }

    private void loginUserWithGoogle() {
        splashFragmentCallback.onLoginWithGoogle();
    }

    private void loginUser() {
        splashFragmentCallback.onLogin("JohnDoe@gmail.com", "JohnDoe2019");




    }
}
