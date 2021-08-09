package com.example.recyclerview_iiii_part13july21;

import android.media.MediaPlayer;

public interface ItemClickListener {
    void onPlayButtonClicked(SongModel song, int position);
    void onPauseButtonClicked(SongModel song, int position);
    void onDeleteButtonClicked(SongModel song, int position);
}
