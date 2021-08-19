package com.example.retrofitusingkotlinwe18aug21

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("comments")
    fun getPosts(@Query("postId") postId: Int): Call<ResponseDTO>
}