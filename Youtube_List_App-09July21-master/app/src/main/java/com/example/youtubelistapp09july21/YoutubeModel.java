package com.example.youtubelistapp09july21;

public class YoutubeModel {
    private String name, url;
    private int image;

    public YoutubeModel(String name, String url, int image) {
        this.name = name;
        this.url = url;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
