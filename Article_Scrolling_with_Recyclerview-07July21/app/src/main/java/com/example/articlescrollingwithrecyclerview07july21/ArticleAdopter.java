package com.example.articlescrollingwithrecyclerview07july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdopter extends RecyclerView.Adapter<ArticleViewHolder> {
    ArrayList<ArticleModel> articleList;
    private ItemClickListener itemClickListener;
    public ArticleAdopter(ArrayList<ArticleModel> articleList, ItemClickListener itemClickListener) {
        this.articleList = articleList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        return new ArticleViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        ArticleModel article = articleList.get(position);
        holder.setData(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
