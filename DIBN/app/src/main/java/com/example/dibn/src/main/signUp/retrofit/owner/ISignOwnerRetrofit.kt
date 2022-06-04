package com.example.dibn.src.main.signUp.retrofit.owner

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST

interface ISignOwnerRetrofit {
    @HTTP(method = "POST", path="/join",hasBody = true)
    fun getLogin(
        @Body body : PostSignOwnerRequest
    ) : Call<PostSignOwnerResponse>
}