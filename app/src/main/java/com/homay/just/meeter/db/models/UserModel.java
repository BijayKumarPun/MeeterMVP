package com.homay.just.meeter.db.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

    String userName;
    String userImageURL;
    String userBio;
    int userPostCount;
    int userReaderCount;
    int userLikeCount;

    public UserModel() {

    }

    protected UserModel(Parcel in) {
        userName = in.readString();
        userImageURL = in.readString();
        userBio = in.readString();
        userPostCount = in.readInt();
        userReaderCount = in.readInt();
        userLikeCount = in.readInt();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public int getUserPostCount() {
        return userPostCount;
    }

    public void setUserPostCount(int userPostCount) {
        this.userPostCount = userPostCount;
    }

    public int getUserReaderCount() {
        return userReaderCount;
    }

    public void setUserReaderCount(int userReaderCount) {
        this.userReaderCount = userReaderCount;
    }

    public int getUserLikeCount() {
        return userLikeCount;
    }

    public void setUserLikeCount(int userLikeCount) {
        this.userLikeCount = userLikeCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(userImageURL);
        dest.writeString(userBio);
        dest.writeInt(userPostCount);
        dest.writeInt(userReaderCount);
        dest.writeInt(userLikeCount);
    }
}
