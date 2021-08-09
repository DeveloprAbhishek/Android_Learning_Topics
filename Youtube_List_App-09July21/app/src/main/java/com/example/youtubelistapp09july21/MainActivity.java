package com.example.youtubelistapp09july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView recyclerView;
    private ArrayList<YoutubeModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        buildData();
        setAdapterData();
    }

    private void setAdapterData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        YoutubeAdapter adapter = new YoutubeAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    private void buildData() {
        for (int i = 0; i < 2; i++) {
            list.add(new YoutubeModel("Bandeya | Arijit Singh | Dil Juunglee | Lyrical",
                    "https://www.youtube.com/watch?v=ZPqzea9bU1c", R.drawable.image1));
            list.add(new YoutubeModel("You have Never seen Earphones like these ! *Nothing Ear 1*",
                    "https://www.youtube.com/watch?v=WvI4C1IlceE", R.drawable.image2));
            list.add(new YoutubeModel("DIL KO KARRAR AAYA Reprise - Neha Kakkar | Rajat Nagpal | Rana | Anshul Garg | Hindi Song 2021",
                    "https://www.youtube.com/watch?v=mn8ywyrgPwQ", R.drawable.image3));
        }
    }

    @Override
    public void onClickItem(YoutubeModel model) {
        Toast.makeText(this, "hey", Toast.LENGTH_SHORT).show();
        String url = model.getUrl();
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        MainActivity.this.startActivity(webIntent);
    }
}