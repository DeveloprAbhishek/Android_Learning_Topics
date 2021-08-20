package com.example.navigation_graph_iw_20aug21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_student_personal_details.*

class StudentPersonalDetailsFragment : Fragment(R.layout.fragment_student_personal_details) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnNext.setOnClickListener {
            val name = etStudentName.text.toString()
            val age = etStudentAge.text.toString().toInt()
            var bundle = Bundle()
            bundle.putString("name", name)
            bundle.putInt("age", age)
            navController.navigate(
                R.id.action_studentPersonalDetailsFragment_to_studentPerformanceDetailsFragment,
                bundle
            )
        }
    }
}