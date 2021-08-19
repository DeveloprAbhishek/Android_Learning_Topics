package com.example.kotlin_post_request_18aug21

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("posts")
    fun getPost() : Call<ResponsePosts>


}