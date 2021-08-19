package com.example.kotlin_scoping_functions_iw_19aug21


import com.google.gson.annotations.SerializedName

data class ResponseUser(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("support")
    var support: Support
)