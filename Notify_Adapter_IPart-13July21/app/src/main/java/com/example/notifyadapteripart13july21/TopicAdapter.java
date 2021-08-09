package com.example.notifyadapteripart13july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopicAdapter extends RecyclerView.Adapter<TopicViewHolder> {
    private ArrayList<TopicModel> topicModelArrayList;
    private ItemClickListener itemClickListener;
    public TopicAdapter(ArrayList<TopicModel> topicModelArrayList, ItemClickListener itemClickListener) {
        this.topicModelArrayList = topicModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new TopicViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        TopicModel topic = topicModelArrayList.get(position);
        holder.setData(topic);
    }

    @Override
    public int getItemCount() {
        return topicModelArrayList.size();
    }
}
