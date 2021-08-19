package com.example.load_ten_animals_profile_in_fragment_18aug21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_animal_detail.*

class AnimalDetailFragment : Fragment(R.layout.fragment_animal_detail) {
    private var list: ArrayList<AnimalModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildAnimalList()
        setAnimalRecyclerView()
    }

    private fun setAnimalRecyclerView() {
        var linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        var animalAdapter = AnimalAdapter(list)
        recyclerView.adapter = animalAdapter
    }

    private fun buildAnimalList() {
        list.add(AnimalModel(R.drawable.dog1, "Dog 1"))
        list.add(AnimalModel(R.drawable.dog2, "Dog 2"))
        list.add(AnimalModel(R.drawable.dog3, "Dog 3"))
        list.add(AnimalModel(R.drawable.dog1, "Dog 1"))
        list.add(AnimalModel(R.drawable.dog2, "Dog 2"))
        list.add(AnimalModel(R.drawable.dog3, "Dog 3"))
        list.add(AnimalModel(R.drawable.dog1, "Dog 1"))
        list.add(AnimalModel(R.drawable.dog2, "Dog 2"))
        list.add(AnimalModel(R.drawable.dog3, "Dog 3"))
        list.add(AnimalModel(R.drawable.dog1, "Dog 1"))
        list.add(AnimalModel(R.drawable.dog2, "Dog 2"))
        list.add(AnimalModel(R.drawable.dog3, "Dog 3"))
    }
}