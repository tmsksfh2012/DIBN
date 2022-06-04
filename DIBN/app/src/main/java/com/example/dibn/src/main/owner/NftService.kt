package com.example.dibn.src.main.owner

import com.example.dibn.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NftService(val view: InftView) {
    fun tryPostNft(nftRequest: PostNftRequest) {
        val iNftRetrofit = ApplicationClass.sRetrofit.create(InftRetrofit::class.java)

        iNftRetrofit.getNft(nftRequest)
            .enqueue(object : Callback<PostNftResponse> {
                override fun onFailure(call: Call<PostNftResponse>, t: Throwable) {
                    view.onPostNftFailure(t.message ?: "통신 오류")
                }

                override fun onResponse(call: Call<PostNftResponse>, response: Response<PostNftResponse>) {
                    view.onPostNftSuccess(response.body() as PostNftResponse)
                }

            })
    }
}