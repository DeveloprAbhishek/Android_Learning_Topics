package com.example.recyclerview_iiii_part13july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView recyclerView;
    private ArrayList<SongModel> songList = new ArrayList<>();
    private SongAdapter songAdapter;
    boolean isPause = false;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setDataAdapter();
    }

    private void setDataAdapter() {
        songAdapter = new SongAdapter(songList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(songAdapter);
    }

    private void buildRecyclerViewData() {
        songList.add(new SongModel(R.drawable.adam, R.raw.ride_it_hindi, "Ride It"));
        songList.add(new SongModel(R.drawable.joshua, R.raw.blue_eyes, "Blue Eyes"));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onPlayButtonClicked(SongModel song, int position) {
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, song.getSong());
        mediaPlayer.start();

    }

    @Override
    public void onPauseButtonClicked(SongModel song, int position) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDeleteButtonClicked(SongModel song, int position) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        songList.remove(position);
        songAdapter.notifyDataSetChanged();
    }
}