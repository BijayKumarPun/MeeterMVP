package com.homay.just.meeter.ui.feeds;

import com.homay.just.meeter.db.models.FeedModel;

import java.util.ArrayList;

public interface FeedFragCC {

    void onFeedRetrieveSuccess(String message, ArrayList<FeedModel> feedModels);
    void onFeedRetrieveFail(String message);
}
