package com.example.dibn.src.main.home.retrofit

import com.google.gson.annotations.SerializedName

data class ItemData(
    @SerializedName("itemId") val itemId : Int,
    @SerializedName("name") val name : String,
    @SerializedName("artist") val artist : String,
    @SerializedName("price") val price : Int,
    @SerializedName("description") val description : String,
    @SerializedName("period") val period : Int,
    @SerializedName("like") val like : Int,
    @SerializedName("category") val category : String,
    @SerializedName("market") val market : String

)
