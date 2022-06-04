package com.example.dibn.src.main.login.retrofit


interface ILoginView {
    fun onGetLoginSuccess(response: GetLoginResponse)
    fun onGetLoginFailure(message: String)
}