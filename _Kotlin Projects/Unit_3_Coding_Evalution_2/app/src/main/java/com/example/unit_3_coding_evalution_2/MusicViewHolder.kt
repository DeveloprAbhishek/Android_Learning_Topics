package com.example.unit_3_coding_evalution_2

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.music_item_layout.view.*

class MusicViewHolder(itemView: View, var itemClickListener: ItemClickListener) : RecyclerView.ViewHolder(itemView) {

    fun setMusicData(result: Result) {
        itemView.apply {
            result?.run {
                tvArtistName.text = artistName
                tvCollectionName.text = collectionName
                tvTrackName.text = trackName
                Glide.with(context).load(artworkUrl100).into(ivImage)
            }
        }


        itemView.cardView.setOnClickListener {
            itemClickListener.onCardClicked(result)
        }
    }
}