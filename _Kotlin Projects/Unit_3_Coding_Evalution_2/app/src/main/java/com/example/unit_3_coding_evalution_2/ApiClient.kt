package com.example.unit_3_coding_evalution_2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("search")
    fun getMusic(@Query("term") term: String): Call<MusicResponse>
}