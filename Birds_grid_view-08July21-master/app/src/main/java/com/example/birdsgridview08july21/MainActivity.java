package com.example.birdsgridview08july21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private final ArrayList<BirdModel> birdList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        buildRecyclerViewData();
        setBirdAdapter();
    }

    private void setBirdAdapter() {
        BirdAdapter birdAdapter = new BirdAdapter(birdList, this);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(birdAdapter);
    }

    private void buildRecyclerViewData() {
        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) {
                birdList.add(new BirdModel(R.drawable.crow, "Crow"));
            } else if (i % 4 == 1) {
                birdList.add(new BirdModel(R.drawable.eagle, "Eagle"));
            } else if (i % 4 == 2) {
                birdList.add(new BirdModel(R.drawable.dove, "Dove"));
            } else if (i % 4 == 3) {
                birdList.add(new BirdModel(R.drawable.parrot, "Parrot"));
            }
        }
    }

    @Override
    public void onClickItem(BirdModel bird) {
        new AlertDialog.Builder(this)
                .setTitle("Bird Name.")
                .setMessage(bird.getBirdName())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).
                setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).
                show();
    }
}