package com.example.navigation_graph_you_20aug21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        getDataFromIntent()
    }

    private fun getDataFromIntent() {
        intent?.run {
            tvTitle.text = getStringExtra("title")
            tvDescription.text = getStringExtra("description")
            tvStartDate.text = getStringExtra("startDate")
            tvEndDate.text = getStringExtra("endDate")
            tvStartTime.text = getStringExtra("startTime")
            tvEndTime.text = getStringExtra("endTime")
            tvCurrency.text = getStringExtra("currency")
            tvPrice.text = getStringExtra("price")
        }

    }
}