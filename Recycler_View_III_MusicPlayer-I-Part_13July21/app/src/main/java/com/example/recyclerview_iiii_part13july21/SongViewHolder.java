package com.example.recyclerview_iiii_part13july21;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongViewHolder extends RecyclerView.ViewHolder {
    private ImageView songImage, playImage, pauseImage, deleteImage;
    private TextView songName;
    private SeekBar seekBar;
    private ItemClickListener itemClickListener;

    public SongViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        songImage = itemView.findViewById(R.id.ivSongImage);
        songName = itemView.findViewById(R.id.tvSongName);
        playImage = itemView.findViewById(R.id.ivSongPlay);
        pauseImage = itemView.findViewById(R.id.ivSongPause);
        deleteImage = itemView.findViewById(R.id.ivSongDelete);
        seekBar = itemView.findViewById(R.id.seekBar);
    }

    public void setData(SongModel song) {
        songImage.setImageResource(song.getSongImage());
        songName.setText(song.getSongName());


        playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onPlayButtonClicked(song, getAdapterPosition());

            }
        });

        pauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onPauseButtonClicked(song, getAdapterPosition());
            }
        });

        deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onDeleteButtonClicked(song, getAdapterPosition());
            }
        });
    }
}
