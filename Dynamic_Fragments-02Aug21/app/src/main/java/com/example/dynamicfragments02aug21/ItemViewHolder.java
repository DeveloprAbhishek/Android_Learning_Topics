package com.example.dynamicfragments02aug21;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView mTvTitle, mTvSubTitle;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        imageView = itemView.findViewById(R.id.ivImage);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mTvSubTitle = itemView.findViewById(R.id.tvSubTitle);
    }

    void setData(ResponseModel model) {
        Glide.with(imageView).load(model.getImage()).into(imageView);
        mTvTitle.setText(model.getTitle());
        mTvSubTitle.setText(model.getSubTitle());
    }

}
