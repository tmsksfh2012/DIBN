package com.example.dibn.src.main.home.retrofit

import com.google.gson.annotations.SerializedName

data class GetItemResponse (
    @SerializedName("itemList") val item: ArrayList<ItemData>
)