package com.example.get_user_details_18aug21

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("/api/users/{id}")
    fun getUser(@Path("id") id: Int): Call<UsersResponse>
}