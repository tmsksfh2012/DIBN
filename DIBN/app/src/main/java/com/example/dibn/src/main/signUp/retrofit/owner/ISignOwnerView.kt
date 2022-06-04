package com.example.dibn.src.main.signUp.retrofit.owner


interface ISignOwnerView {
    fun onPostSignOwnerSuccess(ownerResponse: PostSignOwnerResponse)
    fun onPostSignOwnerFailure(message: String)
}