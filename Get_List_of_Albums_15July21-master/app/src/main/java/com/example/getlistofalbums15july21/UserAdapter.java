package com.example.getlistofalbums15july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<ResponseModel> responseModelList;

    public UserAdapter(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        ResponseModel model = responseModelList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}
