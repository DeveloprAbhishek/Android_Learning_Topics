package com.example.birdsgridview08july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BirdAdapter extends RecyclerView.Adapter<BirdViewHolder> {
    private ArrayList<BirdModel> birdModelArrayList;
    private ItemClickListener itemClickListener;

    public BirdAdapter(ArrayList<BirdModel> birdModelArrayList, ItemClickListener itemClickListener) {
        this.birdModelArrayList = birdModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public BirdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new BirdViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BirdViewHolder holder, int position) {
        BirdModel bird = birdModelArrayList.get(position);
        holder.setData(bird);
    }

    @Override
    public int getItemCount() {
        return birdModelArrayList.size();
    }
}
