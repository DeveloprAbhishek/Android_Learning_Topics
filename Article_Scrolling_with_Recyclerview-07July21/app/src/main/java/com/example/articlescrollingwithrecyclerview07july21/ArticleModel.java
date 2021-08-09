package com.example.articlescrollingwithrecyclerview07july21;

public class ArticleModel {
    private int image;
    private String author, title, description;

    public ArticleModel(int image, String author, String title, String description) {
        this.image = image;
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
