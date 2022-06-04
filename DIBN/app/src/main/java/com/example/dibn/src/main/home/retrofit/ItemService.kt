package com.example.dibn.src.main.home.retrofit

import com.example.dibn.config.ApplicationClass
import com.example.dibn.src.main.login.retrofit.IItemView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemService(val view: IItemView) {
    fun tryGetItem(itemRequest: GetItemRequest) {
        val iNewRetrofit = ApplicationClass.sRetrofit.create(IItemRetrofit::class.java)
        iNewRetrofit.getItem(itemRequest.x_auth_token, itemRequest)
            .enqueue(object : Callback<GetItemResponse> {
                override fun onFailure(call: Call<GetItemResponse>, t: Throwable) {
                    view.onGetItemFailure(t.message ?: "통신 오류")
                }

                override fun onResponse(call: Call<GetItemResponse>, response: Response<GetItemResponse>) {
                    view.onGetItemSuccess(response.body() as GetItemResponse)
                }

            })
    }
}