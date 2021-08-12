package com.example.boundedserviceiw12aug21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnPlay, mBtnPause, mBtnStop;
    private MusicService musicService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.ServiceBinder serviceBinder = (MusicService.ServiceBinder) service;
            musicService  = serviceBinder.getMusicService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    private void initViews() {
        mBtnPlay = findViewById(R.id.btnPlay);
        mBtnPause = findViewById(R.id.btnPause);
        mBtnStop = findViewById(R.id.btnStop);

        mBtnPlay.setOnClickListener(this);
        mBtnPause.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnPlay:
                musicService.play();
                break;
            case R.id.btnPause:
                musicService.pause();
                break;
            case R.id.btnStop:
                musicService.stop();
                break;
        }
    }
}