package com.example.kotlin_scoping_functions_iw_19aug21

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/users/{ID}")
    fun getUserData(@Path("ID") id: Int): Call<ResponseUser>
}