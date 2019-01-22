package com.homay.just.meeter.presenter;

import android.content.Context;
import android.content.Intent;

import com.homay.just.meeter.presenter.activity.home.HomeActivity;

public class MainPresenter implements MainPresenterInterface{

    @Override
    public void startHomeActivity(Context context) {
        context.startActivity(new Intent(context,HomeActivity.class));

    }
}
