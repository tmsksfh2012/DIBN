package com.example.dibn.src.main.signUp.retrofit.owner

import com.google.gson.annotations.SerializedName

data class PostSignOwnerResponse (
    @SerializedName("userId") val user_id : String
        )