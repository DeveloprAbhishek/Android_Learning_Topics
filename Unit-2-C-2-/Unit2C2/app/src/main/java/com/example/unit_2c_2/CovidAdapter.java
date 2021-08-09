package com.example.unit_2c_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<CovidViewHolder> {
    private List<ResponseModel> responseModelList;
    private ItemClickListener itemClickListener;

    public CovidAdapter(List<ResponseModel> responseModelList, ItemClickListener itemClickListener) {
        this.responseModelList = responseModelList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CovidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new CovidViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidViewHolder holder, int position) {
        ResponseModel model = responseModelList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}
