package com.example.kotlin_scoping_functions_you_19aug21


import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("text")
    var text: String,
    @SerializedName("url")
    var url: String
)