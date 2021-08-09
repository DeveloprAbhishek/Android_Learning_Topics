package com.example.inshortsnewsapp16july21;

import android.content.ClipData;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvNewsImage;
    private TextView mTvAuthor, mTvDate, mTvTime, mTvTitle, mTvContent;
    private CardView cardView;
    private ItemClickListener itemClickListener;
    public NewsViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);

    }

    private void initViews(View itemView) {
        mIvNewsImage = itemView.findViewById(R.id.ivNewsImage);
        mTvAuthor = itemView.findViewById(R.id.tvAuthor);
        mTvDate = itemView.findViewById(R.id.tvDate);
        mTvTime = itemView.findViewById(R.id.tvTime);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mTvContent = itemView.findViewById(R.id.tvContent);
        cardView = itemView.findViewById(R.id.cardView);


    }

    public void setData(DataModel data) {
        mTvAuthor.setText(data.getAuthor());
        mTvTitle.setText(data.getTitle());
        Glide.with(mIvNewsImage).load(data.getImageUrl()).into(mIvNewsImage);
        mTvContent.setText(data.getContent());
        mTvTime.setText(data.getTime());
        mTvDate.setText(data.getDate());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickItem(data);
            }
        });
    }
}
