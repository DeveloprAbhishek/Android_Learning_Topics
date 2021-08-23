package com.example.unit_3_coding_evalution_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(var list: List<Result>, var itemClickListener: ItemClickListener) : RecyclerView.Adapter<MusicViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.music_item_layout, parent, false)
        return MusicViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.setMusicData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}