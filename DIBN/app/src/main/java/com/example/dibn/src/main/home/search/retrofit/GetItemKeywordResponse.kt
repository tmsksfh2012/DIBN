package com.example.dibn.src.main.home.search.retrofit

import com.example.dibn.src.main.home.retrofit.ItemData
import com.google.gson.annotations.SerializedName

data class GetItemKeywordResponse (
    @SerializedName("itemList") val item: ArrayList<ItemData>
)