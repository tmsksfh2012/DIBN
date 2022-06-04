package com.example.dibn.src.main.home.retrofit

import com.google.gson.annotations.SerializedName

data class GetItemRequest (
    @SerializedName("X-AUTH-TOKEN") val x_auth_token : String)