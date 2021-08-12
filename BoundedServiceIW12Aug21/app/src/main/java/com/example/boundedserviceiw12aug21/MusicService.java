package com.example.boundedserviceiw12aug21;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new  ServiceBinder();
    }

    public void play() {

        mediaPlayer = MediaPlayer.create(this, R.raw.baby);
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            Log.d("Abhishek", "Play");
        }
    }

    public void pause() {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void stop() {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public class ServiceBinder extends Binder {
        public  MusicService getMusicService() {
            return MusicService.this;
        }
    }
}