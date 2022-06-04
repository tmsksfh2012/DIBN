package com.example.dibn.src.main.signUp.retrofit.consumer


interface ISignConsumerView {
    fun onPostSignConsumerSuccess(consumerResponse: PostSignConsumerResponse)
    fun onPostSignConsumerFailure(message: String)
}