package com.example.itunesapi15july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
    private List<ResultsModel> list;
    private ItemClickListener itemClickListener;
    public SongAdapter(List<ResultsModel> list, ItemClickListener itemClickListener) {
        this.list = list;
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
        ResultsModel resultsModel = list.get(position);
        holder.setData(resultsModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
