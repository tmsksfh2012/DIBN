package com.example.dibn.src.main.login.retrofit

import com.google.gson.annotations.SerializedName

data class GetLoginResponse (
    @SerializedName("X-AUTH-TOKEN") val x_auth_token : String
        )