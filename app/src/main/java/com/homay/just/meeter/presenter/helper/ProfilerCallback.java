package com.homay.just.meeter.presenter.helper;

import com.homay.just.meeter.db.models.UserModel;

public interface ProfilerCallback {

    void onProfileRetrieveSuccess(String message, UserModel userModel);
    void onProfileRetrieveFail(String message);

    void onProfileEditSuccess(String message);
    void onProfileEditFailed(String message);
}
