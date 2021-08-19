package com.example.kotlin_post_request_18aug21


import com.google.gson.annotations.SerializedName

data class RequestPost(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("requestType")
    var requestType: String,
    @SerializedName("title")
    var title: String
)