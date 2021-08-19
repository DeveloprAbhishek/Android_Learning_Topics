package com.example.retrofitusingkotlinwe18aug21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var responseList: ResponseDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPost.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getPosts(etPostId.text.toString().toInt())
            .enqueue(object: Callback<ResponseDTO> {
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    responseList = response.body()!!
                    setRecyclerView()
                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                }

            })

    }

    private fun setRecyclerView() {
        val postAdapter = PostAdapter(responseList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter
        recyclerView.layoutManager = linearLayoutManager
    }
}