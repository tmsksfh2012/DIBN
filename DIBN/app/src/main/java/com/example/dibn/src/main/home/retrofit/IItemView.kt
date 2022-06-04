package com.example.dibn.src.main.login.retrofit

import com.example.dibn.src.main.home.retrofit.GetItemRequest
import com.example.dibn.src.main.home.retrofit.GetItemResponse


interface IItemView {
    fun onGetItemSuccess(response: GetItemResponse)
    fun onGetItemFailure(message: String)
}