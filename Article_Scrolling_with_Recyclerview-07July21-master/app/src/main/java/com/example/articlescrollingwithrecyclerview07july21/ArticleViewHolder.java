package com.example.articlescrollingwithrecyclerview07july21;

import android.content.ClipData;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView author, title, description;
    LinearLayout linearLayout;
    private final ItemClickListener itemClickListener;

    public ArticleViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        image = itemView.findViewById(R.id.ivArticleImage);
        author = itemView.findViewById(R.id.tvArticleAuthor);
        title = itemView.findViewById(R.id.tvArticleTitle);
        description = itemView.findViewById(R.id.tvArticleDescription);
        linearLayout = itemView.findViewById(R.id.linearLayout);
    }

    public void setData(ArticleModel article) {
        image.setImageResource(article.getImage());
        author.setText(article.getAuthor());
        title.setText(article.getTitle());
        description.setText(article.getDescription());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(article);
            }
        });
    }
}
