package com.homay.just.meeter.presenter.helper;

import android.util.Log;

import com.homay.just.meeter.db.models.UserModel;
import com.homay.just.meeter.db.user.User;
import com.homay.just.meeter.db.user.UserStateCallback;

public class Profiler implements UserStateCallback {
    private String TAG = "Profiler";

    ProfilerCallback profilerCallback;

    //Profiler Requests
    ProfilerRequests profilerRequests;

    //User
    User user;

    public Profiler(){

        user = new User();
        profilerRequests = user;
        user.setUserStateCallback(this);
    }

  public   void retrieveCurrentProfile(String userToDownload) {
        profilerRequests.downloadCurrentUser(userToDownload);
    }
    public void editCurrentProfile(String userDetailToEdit) {
        profilerRequests.editCurrentUser(userDetailToEdit);
    }


    @Override
    public void onUserDownloadSuccess(String message, UserModel userModel) {
        Log.i(TAG, "onUserDownloadSuccess: Successfully downloaded");
        profilerCallback.onProfileRetrieveSuccess(message,userModel);

    }

    @Override
    public void onUserDownloadFail(String message) {
        Log.i(TAG, "onUserDownloadFail: Fail downloading user");
        profilerCallback.onProfileRetrieveFail(message);

    }

    @Override
    public void onUserEditSuccess(String message) {
        Log.i(TAG, "onUserEditSuccess: ");
        profilerCallback.onProfileEditSuccess(message);

    }

    @Override
    public void onUserEditFail(String message) {
        Log.i(TAG, "onUserEditFail: ");
        profilerCallback.onProfileEditFailed(message);

    }

    public void setProfilerCallback(ProfilerCallback profilerCallback) {
        this.profilerCallback = profilerCallback;
    }
}
