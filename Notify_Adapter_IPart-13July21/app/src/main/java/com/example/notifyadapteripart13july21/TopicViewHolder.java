package com.example.notifyadapteripart13july21;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TopicViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private TextView topicName;
    private ItemClickListener itemClickListener;
    boolean isTrue = true;
    public TopicViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        topicName = itemView.findViewById(R.id.tvTopicName);
        cardView = itemView.findViewById(R.id.itemCardView);
    }

    public void setData(TopicModel topic) {
        topicName.setText(topic.getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //itemClickListener.onItemClicked(getAdapterPosition(), cardView, topicName, isTrue);
                if(isTrue) {
                    cardView.setCardBackgroundColor(Color.parseColor("#0583EA"));
                    topicName.setTextColor(Color.parseColor("#FFFFFF"));
                    isTrue = false;
                } else {
                    cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    topicName.setTextColor(Color.parseColor("#0583EA"));
                    isTrue = true;
                }

            }
        });
    }
}
