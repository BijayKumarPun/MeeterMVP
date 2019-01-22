package com.homay.just.meeter.presenter.activity.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.homay.just.meeter.R;
import com.homay.just.meeter.db.models.FeedModel;
import com.homay.just.meeter.db.models.UserModel;
import com.homay.just.meeter.db.network_handler.FeedDownloader;
import com.homay.just.meeter.db.network_handler.FeedDownloaderCallback;
import com.homay.just.meeter.db.network_handler.FeedRequests;
import com.homay.just.meeter.presenter.MainPresenter;
import com.homay.just.meeter.presenter.MainPresenterInterface;
import com.homay.just.meeter.presenter.helper.Profiler;
import com.homay.just.meeter.presenter.helper.ProfilerCallback;
import com.homay.just.meeter.ui.composer.ComposerFrag;
import com.homay.just.meeter.ui.feeds.FeedActions;
import com.homay.just.meeter.ui.feeds.FeedFrag;
import com.homay.just.meeter.ui.feeds.FeedFragCC;
import com.homay.just.meeter.ui.profile.ProfileFrag;

import java.util.ArrayList;

//This activity is started after successful signin

//TODO
//TODO Downoad user profile

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ProfilerCallback,FeedActions, FeedDownloaderCallback {
    private String TAG = "HomeActivity";
    //Profiler
    Profiler profiler;

    //MainPresenter
    MainPresenter mainPresenter;
    MainPresenterInterface mainPresenterInterface;


    //Layout
    //Bottom nav view
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout_container_main;

    //FragmentManager
    FragmentManager fragmentManager;

    //Fragments
    ProfileFrag profileFrag;
    FeedFrag feedFrag;
    ComposerFrag composerFrag;

    //Current user
    UserModel currentUserModel;
    Bundle currentUserModelBundle;

    //FeedDownloader to download feeds
    FeedDownloader feedDownloader;

    FeedRequests feedRequests;

    //FeedCC to communicate with FeedFrag
    FeedFragCC feedFragCC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Instantiation
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        frameLayout_container_main = findViewById(R.id.frame_layout_fragment_container_);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        //Profiler
        //Downloads current user profile
        profiler = new Profiler();
        profiler.setProfilerCallback(this);


        //Current user stuff
        currentUserModel = new UserModel();
        currentUserModelBundle = new Bundle();

        //get profile
        profiler.retrieveCurrentProfile("JohnDoe@gmail.com");

        //MainPresenter
        mainPresenter = new MainPresenter();
        mainPresenterInterface = mainPresenter;

        //FragmentManager
        fragmentManager = getSupportFragmentManager();

        //Fragments
        feedFrag = new FeedFrag();
        profileFrag = new ProfileFrag();
        composerFrag = new ComposerFrag();

        //onstart
        startFeedFragment();

        //FeedDownloader to download feeds
        feedDownloader = new FeedDownloader();
        feedRequests = feedDownloader;

        feedDownloader.setFeedDownloaderCallback(this);


        //FeedFragCC
        feedFragCC = feedFrag;

        //FeedActions interface
        feedFrag.setFeedActionsInterface(this);


    }


    //ProfilerCallback stuff

    @Override
    public void onProfileRetrieveSuccess(String message, UserModel userModel) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onProfileRetrieveSuccess: " + message);

        currentUserModel = userModel;
        currentUserModelBundle.putParcelable("current_user_data", currentUserModel);

        //Check downloaded profile data
        String TAG = "CHECK";
        Log.i(TAG, "onProfileRetrieveSuccess: User name" + userModel.getUserName());
        Log.i(TAG, "onProfileRetrieveSuccess: User reader count" + userModel.getUserReaderCount());

        //TODO Get the retrieved profile and pass to fragment profile
    }

    @Override
    public void onProfileRetrieveFail(String message) {

    }

    @Override
    public void onProfileEditSuccess(String message) {

    }

    @Override
    public void onProfileEditFailed(String message) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.bottom_nav_menu_feed:
                startFeedFragment();
                return true;

            case R.id.bottom_nav_menu_compose:
                startComposerFragment();
                return true;

            case R.id.bottom_nav_menu_profile:
                startProfileFragment();
                return true;
        }
        return false;
    }

    private void startProfileFragment() {
        //TODO Get the user data from the onRetrieve Success method
        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_profile).setChecked(true);
        //key to Parcelable data "current_user_data"
        profileFrag.setArguments(currentUserModelBundle);

        fragmentManager.beginTransaction().replace(R.id.frame_layout_fragment_container_, profileFrag, "ProfileFrag").commit();
    }

    private void startComposerFragment() {
        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_compose).setChecked(true);
        fragmentManager.beginTransaction().replace(R.id.frame_layout_fragment_container_, composerFrag, "ComposeFrag").commit();
    }

    private void startFeedFragment() {
        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_feed).setChecked(true);
        fragmentManager.beginTransaction().replace(R.id.frame_layout_fragment_container_, feedFrag, "FeedFrag").commit();

    }


    //FeedActions interface implementaton
    @Override
    public void getFeed() {
        Log.i(TAG, "getFeed: ");

        feedRequests.getFeed();

    }


    //FeedDownloader callback
    @Override
    public void onFeedDownloadSuccess(String message, ArrayList<FeedModel> feedModels) {
        feedFragCC.onFeedRetrieveSuccess(message, feedModels);
    }

    @Override
    public void onFeedDownloadFail(String message) {
        feedFragCC.onFeedRetrieveFail(message);
    }
}
