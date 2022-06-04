package com.example.dibn.src.main.home.search.retrofit

import com.google.gson.annotations.SerializedName

data class GetItemKeywordRequest (
    @SerializedName("keyword") val keyword : String
    )