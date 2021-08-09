package com.example.fragmentsloadgithubprofilesinrecyclerview30july21;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class ProfileViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView mTvName, mTvLogin;

    public ProfileViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        imageView = itemView.findViewById(R.id.ivImage);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvLogin = itemView.findViewById(R.id.tvLogin);
    }

    void setData(ResponseModel model) {
        if(model.getOwner().getAvatarUrl() != null) {
            Glide.with(imageView).load(model.getOwner().getAvatarUrl()).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.ic_launcher_background);
        }

        mTvName.setText(model.getName());
        mTvLogin.setText(model.getOwner().getLogin());
    }
}
