package com.example.birdsgridview08july21;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BirdViewHolder extends RecyclerView.ViewHolder {
    private ImageView birdImage;
    private TextView birdName;
    LinearLayout linearLayout;
    private ItemClickListener itemClickListener;

    public BirdViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View view) {
        birdImage = view.findViewById(R.id.ivBirdImage);
        birdName = view.findViewById(R.id.tvBirdName);
        linearLayout = view.findViewById(R.id.itemLinearLayout);
    }

    public void setData(BirdModel bird) {
        birdImage.setImageResource(bird.getBirdImage());
        birdName.setText(bird.getBirdName());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickItem(bird);
            }
        });
    }
}
