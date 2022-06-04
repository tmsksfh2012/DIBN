package com.example.dibn.src.main.signUp.retrofit.owner

import com.google.gson.annotations.SerializedName

data class PostSignOwnerRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("address") val address: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("role") val role: String,
    @SerializedName("marketName") val marketName : String
)