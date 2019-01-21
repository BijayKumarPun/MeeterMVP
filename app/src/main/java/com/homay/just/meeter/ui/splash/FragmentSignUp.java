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

public class FragmentSignUp extends Fragment implements View.OnClickListener {
    Button buttonSignUp;
    TextView textViewHasAccount;
    SplashFragmentCallback splashFragmentCallback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View signUpView = inflater.inflate(R.layout.fragment_signup,container,false);

        buttonSignUp = signUpView.findViewById(R.id.button_signup_);
        textViewHasAccount = signUpView.findViewById(R.id.textView_option_hasAccount);

        //set click listerner
        buttonSignUp.setOnClickListener(this);
        textViewHasAccount.setOnClickListener(this);

        return signUpView;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_signup_:
                signUpUser();
                break;

            case R.id.textView_option_hasAccount:
                loginUser();
                break;
        }
    }

    private void loginUser() {
splashFragmentCallback.onSignIn();

    }

    private void signUpUser() {
        splashFragmentCallback.onSignUp("JohnDoe@gmail.com","Doe");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SplashFragmentCallback) {
            this.splashFragmentCallback = ((SplashFragmentCallback) context);

        } else {
            throw new RuntimeException("SplashFragmentCallback is not implemented");
        }
    }
}
