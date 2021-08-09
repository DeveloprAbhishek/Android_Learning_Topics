package com.example.recyclerviewviewtypeswe14july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BaseModel> baseModelList;

    public ChatAdapter(ArrayList<BaseModel> baseModelList) {
        this.baseModelList = baseModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View senderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_item_layout, parent, false);
                return new SenderViewHolder(senderView);
            case 1:
                View receiverView = LayoutInflater.from(parent.getContext()).inflate(R.layout.receiver_item_layout, parent, false);
                return new ReceiverViewHolder(receiverView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = baseModelList.get(position).getViewType();
        switch (viewType) {
            case 0:
                if(holder instanceof SenderViewHolder) {
                    ((SenderViewHolder) holder).setData((SenderModel) baseModelList.get(position));
                }
                break;
            case 1:
                if (holder instanceof ReceiverViewHolder) {
                    ReceiverModel receiverModel = (ReceiverModel) baseModelList.get(position);
                    ((ReceiverViewHolder) holder).setData(receiverModel);
                }
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return baseModelList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return baseModelList.size();
    }
}
