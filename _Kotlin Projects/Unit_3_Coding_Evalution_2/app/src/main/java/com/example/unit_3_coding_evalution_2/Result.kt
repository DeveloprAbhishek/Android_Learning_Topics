package com.example.unit_3_coding_evalution_2


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("artistId")
    var artistId: Int,
    @SerializedName("artistName")
    var artistName: String,
    @SerializedName("artistViewUrl")
    var artistViewUrl: String,
    @SerializedName("artworkUrl100")
    var artworkUrl100: String,
    @SerializedName("artworkUrl30")
    var artworkUrl30: String,
    @SerializedName("artworkUrl60")
    var artworkUrl60: String,
    @SerializedName("collectionArtistId")
    var collectionArtistId: Int,
    @SerializedName("collectionArtistName")
    var collectionArtistName: String,
    @SerializedName("collectionArtistViewUrl")
    var collectionArtistViewUrl: String,
    @SerializedName("collectionCensoredName")
    var collectionCensoredName: String,
    @SerializedName("collectionExplicitness")
    var collectionExplicitness: String,
    @SerializedName("collectionId")
    var collectionId: Int,
    @SerializedName("collectionName")
    var collectionName: String,
    @SerializedName("collectionPrice")
    var collectionPrice: Double,
    @SerializedName("collectionViewUrl")
    var collectionViewUrl: String,
    @SerializedName("country")
    var country: String,
    @SerializedName("currency")
    var currency: String,
    @SerializedName("discCount")
    var discCount: Int,
    @SerializedName("discNumber")
    var discNumber: Int,
    @SerializedName("isStreamable")
    var isStreamable: Boolean,
    @SerializedName("kind")
    var kind: String,
    @SerializedName("previewUrl")
    var previewUrl: String,
    @SerializedName("primaryGenreName")
    var primaryGenreName: String,
    @SerializedName("releaseDate")
    var releaseDate: String,
    @SerializedName("trackCensoredName")
    var trackCensoredName: String,
    @SerializedName("trackCount")
    var trackCount: Int,
    @SerializedName("trackExplicitness")
    var trackExplicitness: String,
    @SerializedName("trackId")
    var trackId: Int,
    @SerializedName("trackName")
    var trackName: String,
    @SerializedName("trackNumber")
    var trackNumber: Int,
    @SerializedName("trackPrice")
    var trackPrice: Double,
    @SerializedName("trackTimeMillis")
    var trackTimeMillis: Int,
    @SerializedName("trackViewUrl")
    var trackViewUrl: String,
    @SerializedName("wrapperType")
    var wrapperType: String
)