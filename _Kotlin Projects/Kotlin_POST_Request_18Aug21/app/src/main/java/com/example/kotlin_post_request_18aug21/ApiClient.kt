package com.example.kotlin_post_request_18aug21

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {
    @GET("posts")
    fun getPost(): Call<ResponsePosts>

    @POST("posts")
    fun postData(@Body requestPost: RequestPost) :Call<ResponsePosts>
}