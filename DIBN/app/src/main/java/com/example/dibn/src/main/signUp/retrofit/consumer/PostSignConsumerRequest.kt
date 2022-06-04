package com.example.dibn.src.main.signUp.retrofit.consumer

import com.google.gson.annotations.SerializedName

data class PostSignConsumerRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("address") val address: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("role") val role: String
)