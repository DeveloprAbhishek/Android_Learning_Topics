package com.example.kotlin_post_request_18aug21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var responsePosts: ResponsePosts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPost.setOnClickListener{
            progressBar.visibility = View.VISIBLE
            callApi();
        }
    }

    private fun callApi() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val requestType = etRequestType.text.toString()
        val title = etTitle.text.toString()
        val requestPost: RequestPost = RequestPost(email, password, requestType, title)
        apiClient.postData(requestPost).enqueue(object : Callback<ResponsePosts> {
            override fun onResponse(call: Call<ResponsePosts>, response: Response<ResponsePosts>) {

                response.body()?.run {
                    val intent = Intent(this@MainActivity, DataShowActivity::class.java)
                    intent.putExtra("email", email)
                    intent.putExtra("title", title)
                    intent.putExtra("password", password)
                    intent.putExtra("requestType", requestType)
                    startActivity(intent)
                    progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<ResponsePosts>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load", Toast.LENGTH_SHORT).show()
            }

        })
    }
}