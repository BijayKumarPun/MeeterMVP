package com.homay.just.meeter.presenter.activity.home;

public interface ProfileViewFunction {

    void setUserImage(String imageURL);
    void setUserName(String userName);
    void setUserBio(String userBio);

    void setUserPostCount(int postCount);

    void setUserReaderCount(int readerCount);

    void setUserLikesCount(int likesCount);


}
