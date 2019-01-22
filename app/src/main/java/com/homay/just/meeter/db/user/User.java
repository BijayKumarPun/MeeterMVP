package com.homay.just.meeter.db.user;

import com.homay.just.meeter.db.models.UserModel;
import com.homay.just.meeter.presenter.helper.ProfilerRequests;

public class User implements ProfilerRequests {

    UserStateCallback userStateCallback;

    public User() {

    }



    public void setUserStateCallback(UserStateCallback userStateCallback) {
        this.userStateCallback = userStateCallback;
    }

    @Override
    public void downloadCurrentUser(String userToDownload) {


        //TODO Download current user here

        UserModel downloadedUser = new UserModel();
        downloadedUser = getDummyUserModel();

        //dummy data

        boolean result = true;
        if (result) {

            userStateCallback.onUserDownloadSuccess("Current user data",downloadedUser);
        }else {
            userStateCallback.onUserDownloadFail("Download fail");

        }





    }

    private UserModel getDummyUserModel() {
        UserModel dummyUserModel = new UserModel();
        dummyUserModel.setUserName("John Doe");
        dummyUserModel.setUserBio("John Doe somewhere from Earth");
        dummyUserModel.setUserImageURL("http://somedummyurl.com/johndoe.jpeg");
        dummyUserModel.setUserLikeCount(10);
        dummyUserModel.setUserPostCount(20);
        dummyUserModel.setUserReaderCount(30);

        return dummyUserModel;
    }

    @Override
    public void editCurrentUser(String userDetailToEdit) {
//Editing current user code goes here
        boolean result = true;
        if(result){
            userStateCallback.onUserEditSuccess("Successfully edited");
        }else{
            userStateCallback.onUserEditFail("Download failed");
        }


    }
}
