package com.homay.just.meeter.db.user;

import com.homay.just.meeter.db.models.UserModel;
import com.homay.just.meeter.presenter.helper.ProfilerRequests;

public interface UserStateCallback  {

    void onUserDownloadSuccess(String message, UserModel userModel);
    void onUserDownloadFail(String message);


    //Edit profile
    void onUserEditSuccess(String message);
    void onUserEditFail(String message);
}

