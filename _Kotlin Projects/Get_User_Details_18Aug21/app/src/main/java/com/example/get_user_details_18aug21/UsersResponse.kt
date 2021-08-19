package com.example.get_user_details_18aug21


import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("support")
    var support: Support
)