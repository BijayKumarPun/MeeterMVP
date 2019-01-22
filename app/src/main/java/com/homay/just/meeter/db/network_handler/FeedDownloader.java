package com.homay.just.meeter.db.network_handler;

import com.homay.just.meeter.db.models.FeedModel;

import java.util.ArrayList;

public class FeedDownloader implements FeedRequests {
    FeedDownloaderCallback feedDownloaderCallback;

    public FeedDownloader() {

    }


    @Override
    public void getFeed() {

        downloadFeed();


    }

    private void downloadFeed() {
        //TODO Download feed from server

        ArrayList<FeedModel> feedModels = new ArrayList<>();


        FeedModel feedModel = new FeedModel();
        feedModel.setFeedCreatorName("Johhny");
        feedModel.setFeedCreationTitle("Sky");
        feedModel.setFeedCreationBody("Something is in the sky");
        feedModel.setFeedCreatorImageURL("http://something.com/somename.jpg");
        feedModel.setFeedViewCount(20);
        feedModel.setFeedLikeCount(28);
        feedModel.setFeedCommentCount(23);

        feedModels.add(feedModel);


        feedDownloaderCallback.onFeedDownloadSuccess("Feed successfully downloaded", feedModels);
    }

    public void setFeedDownloaderCallback(FeedDownloaderCallback feedDownloaderCallback) {
        this.feedDownloaderCallback= feedDownloaderCallback;
    }

}
