package com.example.dibn.src.main.home.search.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface IKeywordRetrofit {
    @POST("/item/search/")
    fun getItem(
        @Header("X-AUTH-TOKEN") header : String,
        @Body body : GetItemKeywordRequest
    ) : Call<GetItemKeywordResponse>
}