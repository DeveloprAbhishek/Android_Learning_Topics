package com.example.notifyadapteripart13july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<TopicModel> topicModels = new ArrayList<>();
    private TopicAdapter topicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        topicAdapter = new TopicAdapter(topicModels, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(topicAdapter);
    }

    private void buildRecyclerViewData() {
        topicModels.add(new TopicModel("Books"));
        topicModels.add(new TopicModel("Podcasts"));
        topicModels.add(new TopicModel("News"));
        topicModels.add(new TopicModel("Business"));
        topicModels.add(new TopicModel("Entertainment"));
        topicModels.add(new TopicModel("Sports"));
        topicModels.add(new TopicModel("Technology"));
        topicModels.add(new TopicModel("Pronunciation"));
        topicModels.add(new TopicModel("Grammar"));
        topicModels.add(new TopicModel("Health"));
        topicModels.add(new TopicModel("Books"));
        topicModels.add(new TopicModel("Books"));
        topicModels.add(new TopicModel("Books"));
        topicModels.add(new TopicModel("Podcasts"));
        topicModels.add(new TopicModel("News"));
        topicModels.add(new TopicModel("Business"));
        topicModels.add(new TopicModel("Entertainment"));
        topicModels.add(new TopicModel("Sports"));
        topicModels.add(new TopicModel("Technology"));
        topicModels.add(new TopicModel("Pronunciation"));
        topicModels.add(new TopicModel("Grammar"));
        topicModels.add(new TopicModel("Health"));
        topicModels.add(new TopicModel("Books"));
        topicModels.add(new TopicModel("Books"));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(int position, CardView cardView, TextView textView, boolean isTrue) {
//        if(isTrue) {
//            cardView.setCardBackgroundColor(Color.parseColor("#0583EA"));
//            textView.setTextColor(Color.parseColor("#FFFFFF"));
//            isTrue = false;
//        } else {
//            cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
//            textView.setTextColor(Color.parseColor("#0583EA"));
//            isTrue = true;
//        }
//        topicAdapter.notifyItemChanged(position);
    }
}