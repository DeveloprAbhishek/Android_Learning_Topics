package com.example.retrofitusingkotlinwe18aug21

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val responseList: ResponseDTO) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.iterm_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val model: ResponseDTOItem = responseList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }
}