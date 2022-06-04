package com.example.dibn.src.main.home.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface IItemRetrofit {
    @POST("/item/all")
    fun getItem(
        @Header("X-AUTH-TOKEN") header : String,
        @Body body : GetItemRequest
    ) : Call<GetItemResponse>
}