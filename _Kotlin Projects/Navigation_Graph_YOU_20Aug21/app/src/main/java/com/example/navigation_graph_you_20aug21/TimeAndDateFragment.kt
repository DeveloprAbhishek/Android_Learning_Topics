package com.example.navigation_graph_you_20aug21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_time_and_date.*

class TimeAndDateFragment : Fragment(R.layout.fragment_time_and_date) {
    private lateinit var title: String
    private lateinit var description: String
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromBundle()
    }

    private fun getDataFromBundle() {
        arguments?.run {
            title = getString("title").toString()
            description = getString("description").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnNextPricePage.setOnClickListener {
            var startData = etStartDate.text.toString()
            var endDate = etEndDate.text.toString()
            var startTime = etStartTime.text.toString()
            var endTime = etEndTime.text.toString()

            var bundle = Bundle()
            bundle.putString("title", title)
            bundle.putString("description", description)
            bundle.putString("startData", startData)
            bundle.putString("endDate", endDate)
            bundle.putString("startTime", startTime)
            bundle.putString("endTime", endTime)
            navController.navigate(R.id.action_timeAndDateFragment_to_priceDetailsFragment, bundle)
        }
    }
}