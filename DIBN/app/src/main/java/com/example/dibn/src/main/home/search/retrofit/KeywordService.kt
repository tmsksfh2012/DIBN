package com.example.dibn.src.main.home.search.retrofit

import com.example.dibn.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KeywordService(val view: IKeywordView)    {
    fun tryGetItem(token: String, itemRequest: GetItemKeywordRequest) {
        val iNewRetrofit = ApplicationClass.sRetrofit.create(IKeywordRetrofit::class.java)
        iNewRetrofit.getItem(token, itemRequest)
            .enqueue(object : Callback<GetItemKeywordResponse> {
                override fun onFailure(call: Call<GetItemKeywordResponse>, t: Throwable) {
                    view.onGetKeywordFailure(t.message ?: "통신 오류")
                }

                override fun onResponse(
                    call: Call<GetItemKeywordResponse>,
                    response: Response<GetItemKeywordResponse>
                ) {
                    view.onGetKeywordSuccess(response.body() as GetItemKeywordResponse)
                }

            })
    }
}