package com.example.viewpagerwithtabs04aug21;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        mTvName = itemView.findViewById(R.id.tvName);
    }

    void setData(String data) {
        mTvName.setText(data);
    }
}
