package com.example.tiktok07aug21;

public class TiktokModel {
    private String title, description;
    private int url;

    public TiktokModel(String title, String description, int url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getUrl() {
        return url;
    }
}
