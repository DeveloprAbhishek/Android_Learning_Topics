package com.example.fragmentsloadgithubprofilesinrecyclerview30july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {
    private List<ResponseModel> list;

    public ProfileAdapter(List<ResponseModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        ResponseModel model = list.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
