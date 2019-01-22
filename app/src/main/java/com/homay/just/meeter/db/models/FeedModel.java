package com.homay.just.meeter.db.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FeedModel implements Parcelable {
    String feedCreatorName;
    String feedCreatorImageURL;
    int feedViewCount;
    int feedLikeCount;
    int feedCommentCount;

    public FeedModel() {

    }

    protected FeedModel(Parcel in) {
        feedCreatorName = in.readString();
        feedCreatorImageURL = in.readString();
        feedViewCount = in.readInt();
        feedLikeCount = in.readInt();
        feedCommentCount = in.readInt();
        feedCreationTitle = in.readString();
        feedCreationBody = in.readString();
    }

    public static final Creator<FeedModel> CREATOR = new Creator<FeedModel>() {
        @Override
        public FeedModel createFromParcel(Parcel in) {
            return new FeedModel(in);
        }

        @Override
        public FeedModel[] newArray(int size) {
            return new FeedModel[size];
        }
    };

    public String getFeedCreatorName() {
        return feedCreatorName;
    }

    public void setFeedCreatorName(String feedCreatorName) {
        this.feedCreatorName = feedCreatorName;
    }

    public String getFeedCreatorImageURL() {
        return feedCreatorImageURL;
    }

    public void setFeedCreatorImageURL(String feedCreatorImageURL) {
        this.feedCreatorImageURL = feedCreatorImageURL;
    }

    public int getFeedViewCount() {
        return feedViewCount;
    }

    public void setFeedViewCount(int feedViewCount) {
        this.feedViewCount = feedViewCount;
    }

    public int getFeedLikeCount() {
        return feedLikeCount;
    }

    public void setFeedLikeCount(int feedLikeCount) {
        this.feedLikeCount = feedLikeCount;
    }

    public int getFeedCommentCount() {
        return feedCommentCount;
    }

    public void setFeedCommentCount(int feedCommentCount) {
        this.feedCommentCount = feedCommentCount;
    }

    public String getFeedCreationTitle() {
        return feedCreationTitle;
    }

    public void setFeedCreationTitle(String feedCreationTitle) {
        this.feedCreationTitle = feedCreationTitle;
    }

    public String getFeedCreationBody() {
        return feedCreationBody;
    }

    public void setFeedCreationBody(String feedCreationBody) {
        this.feedCreationBody = feedCreationBody;
    }

    String feedCreationTitle;
    String feedCreationBody;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(feedCreatorName);
        dest.writeString(feedCreatorImageURL);
        dest.writeInt(feedViewCount);
        dest.writeInt(feedLikeCount);
        dest.writeInt(feedCommentCount);
        dest.writeString(feedCreationTitle);
        dest.writeString(feedCreationBody);
    }
}
