package com.example.birdsgridview08july21;

public class BirdModel {
    int birdImage;
    String birdName;

    public BirdModel(int birdImage, String birdName) {
        this.birdImage = birdImage;
        this.birdName = birdName;
    }

    public int getBirdImage() {
        return birdImage;
    }

    public String getBirdName() {
        return birdName;
    }
}
