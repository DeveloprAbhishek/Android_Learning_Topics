package com.example.load_ten_animals_profile_in_fragment_18aug21

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.animal_item_layout.view.*

class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(animalModel: AnimalModel) {
        itemView.apply {
            tvAnimalName.text = animalModel.name
            Glide.with(ivAnimal).load(animalModel.image).into(ivAnimal)
        }
    }
}