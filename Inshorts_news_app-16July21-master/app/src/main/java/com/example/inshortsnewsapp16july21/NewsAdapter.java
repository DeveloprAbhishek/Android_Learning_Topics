package com.example.inshortsnewsapp16july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<DataModel> dataModelList;
    private ItemClickListener itemClickListener;
    public NewsAdapter(List<DataModel> dataModelList, ItemClickListener itemClickListener) {
        this.dataModelList = dataModelList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
        return new NewsViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        DataModel data = dataModelList.get(position);
        holder.setData(data);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }
}
