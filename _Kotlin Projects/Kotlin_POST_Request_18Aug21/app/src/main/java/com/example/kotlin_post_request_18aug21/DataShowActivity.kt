package com.example.kotlin_post_request_18aug21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data_show.*

class DataShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_show)

        showData()
    }

    private fun showData() {
        tvEmail.text = intent.getStringExtra("email")
        tvTitle.text = intent.getStringExtra("title")
        tvPassword.text = intent.getStringExtra("password")
        tvRequestType.text = intent.getStringExtra("requestType")
    }
}