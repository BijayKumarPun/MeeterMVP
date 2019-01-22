package com.homay.just.meeter.presenter.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.homay.just.meeter.R;
import com.homay.just.meeter.db.models.FeedModel;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {
    ArrayList<FeedModel> feedModels;

    public FeedAdapter(ArrayList<FeedModel> feedModels) {
        this.feedModels = feedModels;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View feedView = layoutInflater.inflate(R.layout.single_feed,viewGroup,false);
        return new FeedViewHolder(feedView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder feedViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {

        ImageView feedCreatorImage;
        TextView feedCreatorName;
        TextView feedTitle, feedBody;
        TextView feedViewCount, feedLikeCount, feedCommentCount;
        ImageView feedOption;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);

            feedCreatorImage = itemView.findViewById(R.id.feed_user_image_);
            feedCreatorName = itemView.findViewById(R.id.feed_userName_);
            feedTitle = itemView.findViewById(R.id.feed_title);
            feedBody = itemView.findViewById(R.id.feed_body);
            feedViewCount = itemView.findViewById(R.id.textView_feed_view_count_);
            feedLikeCount = itemView.findViewById(R.id.textView_feed_like_count);
            feedCommentCount = itemView.findViewById(R.id.textview_feed_comment_count);
            feedOption = itemView.findViewById(R.id.feed_option_);

        }
    }

}
