package com.example.unit_3_coding_evalution_2


import com.google.gson.annotations.SerializedName

data class MusicResponse(
    @SerializedName("resultCount")
    var resultCount: Int,
    @SerializedName("results")
    var results: List<Result>
)