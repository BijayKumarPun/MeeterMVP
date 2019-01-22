package com.homay.just.meeter.ui.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.homay.just.meeter.R;
import com.homay.just.meeter.db.models.UserModel;


public class ProfileFrag extends Fragment {

    //Views from main layout
    ImageView userImage;
    TextView userName;
    TextView userBio;
    TextView userPostCount, userLikeCount, userReaderCount;

    //UserModel
    UserModel currentUser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View profileView = inflater.inflate(R.layout.fragment_profile, container, false);

        //getArguments
        //key to Parcelable data for currentUser "current_user_data"

        if (getArguments() != null) {
             currentUser = getArguments().getParcelable("current_user_data");
        }




        //instantiation

        userImage = profileView.findViewById(R.id.user_profile_image);
        userName = profileView.findViewById(R.id.user_profile_name);
        userBio = profileView.findViewById(R.id.user_profile_bio);
        userPostCount = profileView.findViewById(R.id.user_profile_post_count);
        userLikeCount = profileView.findViewById(R.id.user_profile_like_count);
        userReaderCount = profileView.findViewById(R.id.user_profile_reader_count);


    setValues(currentUser);





        return profileView;
    }

    private void setValues(UserModel currentUser) {

        //PS: UserModel has 6 fields
        String imageURL_ = currentUser.getUserImageURL();
        String userName_ = currentUser.getUserName();
        String userBio_ = currentUser.getUserBio();
        int userPostCount_ = currentUser.getUserPostCount();
        int userLikeCount_ = currentUser.getUserLikeCount();
        int userReaderCount_ = currentUser.getUserReaderCount();

        //TODO Set image using glide
        userName.setText(userName_);
        userBio.setText(userBio_);
        userPostCount.setText(String.valueOf(userPostCount_));
        userLikeCount.setText(String.valueOf(userLikeCount_));
        userReaderCount.setText(String.valueOf(userReaderCount_));

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_profile, menu);
    }

}
