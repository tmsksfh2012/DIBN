package com.example.dibn.src.main.login.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ILoginRetrofit {
    @POST("/login")
    fun getLogin(
        @Body body : GetLoginRequest
    ) : Call<GetLoginResponse>
}