package com.example.dibn.src.main.signUp.retrofit.consumer

import com.example.dibn.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignConsumerService(val consumerView: ISignConsumerView) {
    fun tryPostSign(loginConsumerRequest: PostSignConsumerRequest) {
        val iNewRetrofit = ApplicationClass.sRetrofit.create(ISignConsumerRetrofit::class.java)
        iNewRetrofit.getLogin(loginConsumerRequest)
            .enqueue(object : Callback<PostSignConsumerResponse> {
                override fun onFailure(call: Call<PostSignConsumerResponse>, t: Throwable) {
                    consumerView.onPostSignConsumerFailure(t.message ?: "통신 오류")
                }

                override fun onResponse(call: Call<PostSignConsumerResponse>, consumerResponse: Response<PostSignConsumerResponse>) {
                    consumerView.onPostSignConsumerSuccess(consumerResponse.body() as PostSignConsumerResponse)
                }

            })
    }
}