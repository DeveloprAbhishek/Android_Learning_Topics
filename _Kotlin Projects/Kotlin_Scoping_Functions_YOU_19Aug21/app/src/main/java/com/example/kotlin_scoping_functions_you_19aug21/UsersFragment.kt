package com.example.kotlin_scoping_functions_you_19aug21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_users.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersFragment : Fragment(R.layout.fragment_users) {
    private lateinit var listOfUsers: List<Data>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiCall()
    }

    private fun apiCall() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getUsers(2).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                response.body()?.run {
                    listOfUsers = data
                    setAdapter()
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
            }

        })
    }

    fun setAdapter() {
        var linearLayoutManager = LinearLayoutManager(context)
        var adapter = UsersAdapter(listOfUsers)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
    }
}