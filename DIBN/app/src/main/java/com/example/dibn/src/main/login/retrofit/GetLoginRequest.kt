package com.example.dibn.src.main.login.retrofit

import com.google.gson.annotations.SerializedName

data class GetLoginRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)