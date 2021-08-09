package com.example.tiktok07aug21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TiktokAdapter extends RecyclerView.Adapter<TiktokViewHolder> {
    private ArrayList<TiktokModel> list;

    public TiktokAdapter(ArrayList<TiktokModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TiktokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        return new TiktokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TiktokViewHolder holder, int position) {
        TiktokModel model = list.get(position);
        holder.setVideoData(model);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
