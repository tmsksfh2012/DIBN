package com.example.dibn.src.main.signUp.retrofit.consumer

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface ISignConsumerRetrofit {
    @GET("/join")
    fun getLogin(
        @Body body : PostSignConsumerRequest
    ) : Call<PostSignConsumerResponse>
}