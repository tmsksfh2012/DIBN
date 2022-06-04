package com.example.dibn.src.main.login.retrofit

import com.example.dibn.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: ILoginView) {
    fun tryGetLogin(itemRequest: GetLoginRequest) {
        val iNewRetrofit = ApplicationClass.sRetrofit.create(ILoginRetrofit::class.java)
        iNewRetrofit.getLogin(itemRequest)
            .enqueue(object : Callback<GetLoginResponse> {
                override fun onFailure(call: Call<GetLoginResponse>, t: Throwable) {
                    view.onGetLoginFailure(t.message ?: "통신 오류")
                }

                override fun onResponse(call: Call<GetLoginResponse>, response: Response<GetLoginResponse>) {
                    view.onGetLoginSuccess(response.body() as GetLoginResponse)
                }

            })
    }
}