package com.example.dibn.src.main.signUp.retrofit.owner

import com.example.dibn.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignOwnerService(val ownerView: ISignOwnerView) {
    fun tryPostSign(loginOwnerRequest: PostSignOwnerRequest) {
        val iNewRetrofit = ApplicationClass.sRetrofit.create(ISignOwnerRetrofit::class.java)
        iNewRetrofit.getLogin(loginOwnerRequest)
            .enqueue(object : Callback<PostSignOwnerResponse> {
                override fun onFailure(call: Call<PostSignOwnerResponse>, t: Throwable) {
                    ownerView.onPostSignOwnerFailure(t.message ?: "통신 오류")
                }

                override fun onResponse(call: Call<PostSignOwnerResponse>, ownerResponse: Response<PostSignOwnerResponse>) {
                    ownerView.onPostSignOwnerSuccess(ownerResponse.body() as PostSignOwnerResponse)
                }

            })
    }
}