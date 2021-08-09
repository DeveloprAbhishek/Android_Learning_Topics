package com.example.callerapp09july21;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName, mTvNumber;
    private ItemClickListener itemClickListener;
    private CardView mTvCardView;

    public ContactViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvNumber = itemView.findViewById(R.id.tvNumber);
        mTvCardView = itemView.findViewById(R.id.cardView);
    }

    void setData(ContactModel contact) {
        mTvName.setText(contact.getName());
        mTvNumber.setText(contact.getNumber());

        mTvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickContact(contact);
            }
        });
    }
}
