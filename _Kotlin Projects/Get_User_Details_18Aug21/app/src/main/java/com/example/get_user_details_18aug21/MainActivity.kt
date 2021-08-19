package com.example.get_user_details_18aug21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCallApi.setOnClickListener{
            callApi()
        }
    }

    private fun callApi() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        val postId = etUserId.text.toString().toInt()
        apiClient.getUser(postId).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                response.body()?.run {
                    data?.apply {
                        tvEmail.text = email
                        tvLastName.text = lastName
                        tvfirstName.text = firstName
                        Glide.with(ivAvatar).load(avatar).into(ivAvatar)
                    }
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load", Toast.LENGTH_SHORT).show()
            }

        })
    }
}