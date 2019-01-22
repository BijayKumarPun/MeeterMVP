package com.homay.just.meeter.ui.feeds;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.homay.just.meeter.R;
import com.homay.just.meeter.db.models.FeedModel;
import com.homay.just.meeter.presenter.adapter.FeedAdapter;

import java.util.ArrayList;

public class FeedFrag extends Fragment implements FeedFragCC {
    private String TAG = "FeedFrag";
    

    //RecyclerView stuff
    RecyclerView recyclerView;
    ArrayList<FeedModel> feedModels;
    FeedAdapter feedAdapter;

    //FeedActions interface
    FeedActions feedActions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View feedView = inflater.inflate(R.layout.fragment_feed, container, false);



        //RecyclerViewStuff
        recyclerView = feedView.findViewById(R.id.recyclerView_feed_container);


        getFeeds();

        return feedView;
    }

    private void getFeeds() {
        Log.i(TAG, "getFeeds: ");
        feedActions.getFeed();


    }

    
    //FeedFragCC interface
    @Override
    public void onFeedRetrieveSuccess(String message, ArrayList<FeedModel> feedModels) {
        Log.i(TAG, "onFeedRetrieveSuccess: ");
        Log.i(TAG, "onFeedRetrieveSuccess: "+feedModels.get(0).getFeedCreationBody());

        Log.i(TAG, "onFeedRetrieveSuccess: "+message);

        displayFeedsInRecyclerView(feedModels);
    }



    @Override
    public void onFeedRetrieveFail(String message) {
        Log.i(TAG, "onFeedRetrieveFail: ");
        
        Toast.makeText(getContext(), "Feed retrieval fail", Toast.LENGTH_SHORT).show();
        
    }

    public void setFeedActionsInterface(FeedActions feedActionsInterface) {
        this.feedActions = feedActionsInterface;
    }

    private void displayFeedsInRecyclerView(ArrayList<FeedModel> feedModels) {
        Log.i(TAG, "displayFeedsInRecyclerView: ");
feedAdapter = new FeedAdapter(feedModels);
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
    }
}
