package com.example.kotlin_scoping_functions_you_19aug21


import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("page")
    var page: Int,
    @SerializedName("per_page")
    var perPage: Int,
    @SerializedName("support")
    var support: Support,
    @SerializedName("total")
    var total: Int,
    @SerializedName("total_pages")
    var totalPages: Int
)