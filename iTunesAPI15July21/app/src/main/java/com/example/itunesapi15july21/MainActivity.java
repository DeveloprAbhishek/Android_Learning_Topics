package com.example.itunesapi15july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private EditText mEtSearchArtist;
    private RecyclerView mRecyclerView;
    private Button mBtnSearch;
    private List<ResultsModel> artistList = new ArrayList<>();
    private SongAdapter songAdapter;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mBtnSearch = findViewById(R.id.btnSearchSong);
        mEtSearchArtist = findViewById(R.id.etSearchArtist);
        mediaPlayer = new MediaPlayer();
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        String artistName = mEtSearchArtist.getText().toString();
        apiService.getTrack(artistName).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.body() != null) {
                    artistList = response.body().getResults();
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.d("Abhishek", t.getMessage());
            }
        });
    }

    private void setAdapter() {
        songAdapter = new SongAdapter(artistList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(songAdapter);
    }


    @Override
    public void onItemPlayButtonClicked(String url) {
        mediaPlayer.reset();
        Uri uri = Uri.parse(url);
        mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();
    }

    @Override
    public void onItemPauseButtonClicked() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onItemDeleteButtonClicked(ResultsModel resultsModel) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        artistList.remove(resultsModel);
        songAdapter.notifyDataSetChanged();
    }
}