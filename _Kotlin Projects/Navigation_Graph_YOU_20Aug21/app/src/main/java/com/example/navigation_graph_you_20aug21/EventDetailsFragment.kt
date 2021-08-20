package com.example.navigation_graph_you_20aug21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_event_details.*

class EventDetailsFragment : Fragment(R.layout.fragment_event_details) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnNextTime.setOnClickListener {
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()

            val bundle = Bundle()
            bundle.putString("title", title)
            bundle.putString("description", description)
            navController.navigate(R.id.action_eventDetailsFragment_to_timeAndDateFragment, bundle)
        }
    }
}