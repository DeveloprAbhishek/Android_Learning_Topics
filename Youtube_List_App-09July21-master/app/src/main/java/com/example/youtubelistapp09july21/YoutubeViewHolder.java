package com.example.youtubelistapp09july21;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class YoutubeViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvImageOfVideo;
    private TextView mTvTitle;
    private CardView mCardView;

    private ItemClickListener itemClickListener;

    public YoutubeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImageOfVideo = itemView.findViewById(R.id.ivImageOfVideo);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardView);
    }

    public void setData(YoutubeModel youtube) {
        mIvImageOfVideo.setImageResource(youtube.getImage());
        mTvTitle.setText(youtube.getName());

        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickItem(youtube);
            }
        });
    }
}
