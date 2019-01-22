package com.homay.just.meeter.db.network_handler;

import com.homay.just.meeter.db.models.FeedModel;

import java.util.ArrayList;

public interface FeedDownloaderCallback {

    void onFeedDownloadSuccess(String message, ArrayList<FeedModel> feedModels);
    void onFeedDownloadFail(String message);
}
