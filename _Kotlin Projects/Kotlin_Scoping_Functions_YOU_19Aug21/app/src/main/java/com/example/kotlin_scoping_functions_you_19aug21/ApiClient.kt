package com.example.kotlin_scoping_functions_you_19aug21

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("api/users/")
    fun getUsers(@Query("page") pageNo: Int): Call<UsersResponse>

}