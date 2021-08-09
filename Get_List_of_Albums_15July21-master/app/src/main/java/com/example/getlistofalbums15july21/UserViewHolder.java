package com.example.getlistofalbums15july21;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvId, mTvTitle;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvId = itemView.findViewById(R.id.tvId);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
    }

    void setData(ResponseModel responseModel) {
        mTvId.setText(responseModel.getId()+"");
        mTvTitle.setText(responseModel.getTitle());
    }
}
