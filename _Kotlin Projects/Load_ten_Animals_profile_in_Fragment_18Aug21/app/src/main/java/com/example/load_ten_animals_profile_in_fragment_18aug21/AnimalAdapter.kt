package com.example.load_ten_animals_profile_in_fragment_18aug21

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val list: ArrayList<AnimalModel>) : RecyclerView.Adapter<AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_item_layout, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = list.get(position)
        holder.setData(animal)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}