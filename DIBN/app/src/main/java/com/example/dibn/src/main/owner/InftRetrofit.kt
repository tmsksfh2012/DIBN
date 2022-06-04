package com.example.dibn.src.main.owner

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface InftRetrofit {
    @POST("/market/item")
    fun getNft(
        @Body body : PostNftRequest
    ) : Call<PostNftResponse>
}