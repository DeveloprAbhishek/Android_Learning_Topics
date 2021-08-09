package com.example.recyclerview_iiii_part13july21;

public class SongModel {
    int songImage, song;
    String songName;

    public SongModel(int songImage, int song, String songName) {
        this.songImage = songImage;
        this.songName = songName;
        this.song = song;
    }

    public int getSongImage() {
        return songImage;
    }

    public String getSongName() {
        return songName;
    }

    public int getSong() {
        return song;
    }
}
