package com.example.tiktok07aug21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ArrayList<TiktokModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initViews();
        buildData();
        setVideoAdapter();
    }

    private void setVideoAdapter() {
        viewPager.setAdapter(new TiktokAdapter(list));
    }

    private void buildData() {
        list.add(new TiktokModel("Video1", "Video1 description", R.raw.tiktok1));
        list.add(new TiktokModel("Video2", "Video1 description", R.raw.tiktok2));
        list.add(new TiktokModel("Video3", "Video1 description", R.raw.tiktok3));
        list.add(new TiktokModel("Video4", "Video1 description", R.raw.tiktok4));
        list.add(new TiktokModel("Video5", "Video1 description", R.raw.tiktok5));

    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        list = new ArrayList<>();
    }
}