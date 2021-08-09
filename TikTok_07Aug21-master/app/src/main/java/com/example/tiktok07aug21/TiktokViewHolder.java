package com.example.tiktok07aug21;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TiktokViewHolder extends RecyclerView.ViewHolder {
    private VideoView videoView;
    private ProgressBar progressBar;
    private TextView title, desc;

    public TiktokViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        videoView = itemView.findViewById(R.id.videoView);
        progressBar = itemView.findViewById(R.id.progressBar);
        title = itemView.findViewById(R.id.tvTitle);
        desc = itemView.findViewById(R.id.tvDescription);
    }

    public void setVideoData(TiktokModel model) {
        String video_url = "android.resource://" + videoView.getContext().getPackageName() + "/" + model.getUrl();
        Uri videoUri = Uri.parse(video_url);
        videoView.setVideoURI(videoUri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressBar.setVisibility(View.GONE);
                mp.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }
}
