package com.example.dibn.src.main.signUp.retrofit.consumer

import com.google.gson.annotations.SerializedName

data class PostSignConsumerResponse (
    @SerializedName("userId") val user_id : String
        )