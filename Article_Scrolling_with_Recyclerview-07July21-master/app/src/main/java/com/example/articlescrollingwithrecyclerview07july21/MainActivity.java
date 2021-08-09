package com.example.articlescrollingwithrecyclerview07july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<ArticleModel> articleDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildArticleData();
        setArticleAdapter();
    }

    private void setArticleAdapter() {
        ArticleAdopter articleAdopter = new ArticleAdopter(articleDataList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(articleAdopter);
    }

    private void buildArticleData() {
        String strDescription = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters.";
        articleDataList.add(new ArticleModel(R.drawable.image1, "Abhishek khichi", "Blue Ocean Waves Crash", strDescription));
        articleDataList.add(new ArticleModel(R.drawable.image2, "Abhishek khichi", "Long Exposure River Bridge", strDescription));
        articleDataList.add(new ArticleModel(R.drawable.image3, "Abhishek khichi", "Blue Ocean Waves Crash", strDescription));
        articleDataList.add(new ArticleModel(R.drawable.image4, "Abhishek khichi", "Long Exposure River Bridge", strDescription));
        articleDataList.add(new ArticleModel(R.drawable.image5, "Abhishek khichi", "Blue Ocean Waves Crash", strDescription));
        articleDataList.add(new ArticleModel(R.drawable.image6, "Abhishek khichi", "Long Exposure River Bridge", strDescription));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rvRecyclerView);
    }

    @Override
    public void onItemClicked(ArticleModel article) {
        Toast.makeText(this, ""+article.getAuthor(), Toast.LENGTH_SHORT).show();
    }
}