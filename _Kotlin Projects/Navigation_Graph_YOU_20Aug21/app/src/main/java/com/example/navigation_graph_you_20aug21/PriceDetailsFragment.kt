package com.example.navigation_graph_you_20aug21

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_price_details.*

class PriceDetailsFragment : Fragment(R.layout.fragment_price_details) {

    private lateinit var title: String
    private lateinit var description: String
    private lateinit var startDate: String
    private lateinit var endDate: String
    private lateinit var startTime: String
    private lateinit var endTime: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromBundle()
    }

    private fun getDataFromBundle() {
        arguments?.run {
            title = getString("title").toString()
            description = getString("description").toString()
            startDate = getString("startDate").toString()
            endDate = getString("endDate").toString()
            startTime = getString("startTime").toString()
            endTime = getString("endTime").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPreview.setOnClickListener {
            var intent = Intent(it.context, PreviewActivity::class.java)
            var currency = etCurrency.text.toString()
            var price = etPrice.text.toString()

            intent.putExtra("title", title)
            intent.putExtra("description", description)
            intent.putExtra("startDate", startDate)
            intent.putExtra("endDate", endDate)
            intent.putExtra("startTime", startTime)
            intent.putExtra("endTime", endTime)
            intent.putExtra("currency", currency)
            intent.putExtra("price", price)
            startActivity(intent)
        }
    }
}