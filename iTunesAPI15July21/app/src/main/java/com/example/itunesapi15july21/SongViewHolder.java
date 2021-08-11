package com.example.itunesapi15july21;

import android.content.ClipData;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SongViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvTrackName, mTvArtistName;
    private ImageView mIvTrackImage, mIvPlayBtn, mIvPauseBtn, mIvDeleteBtn;
    private ItemClickListener itemClickListener;
    public SongViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvTrackName = itemView.findViewById(R.id.tvTrackName);
        mTvArtistName = itemView.findViewById(R.id.tvArtistName);
        mIvTrackImage = itemView.findViewById(R.id.ivTrackImage);
        mIvPlayBtn = itemView.findViewById(R.id.ivPlayBtn);
        mIvPauseBtn = itemView.findViewById(R.id.ivPauseBtn);
        mIvDeleteBtn = itemView.findViewById(R.id.ivDeleteBtn);

    }

    void setData(ResultsModel resultsModel) {
        mTvArtistName.setText(resultsModel.getArtistName());
        mTvTrackName.setText(resultsModel.getTrackName());
        Glide.with(mIvTrackImage).load(resultsModel.getArtworkUrl100()).into(mIvTrackImage);

        mIvPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemPlayButtonClicked(resultsModel.getPreviewUrl());
            }
        });

        mIvPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemPauseButtonClicked();
            }
        });

        mIvDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemDeleteButtonClicked(resultsModel);
            }
        });
    }

}
