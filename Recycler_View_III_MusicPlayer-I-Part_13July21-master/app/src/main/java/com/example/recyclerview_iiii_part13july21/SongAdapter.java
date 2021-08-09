package com.example.recyclerview_iiii_part13july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
    private ArrayList<SongModel> songModelArrayList;
    private ItemClickListener itemClickListener;
    public SongAdapter(ArrayList<SongModel> songModelArrayList, ItemClickListener itemClickListener) {
        this.songModelArrayList = songModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new SongViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        SongModel song = songModelArrayList.get(position);
        holder.setData(song);
    }

    @Override
    public int getItemCount() {
        return songModelArrayList.size();
    }
}
