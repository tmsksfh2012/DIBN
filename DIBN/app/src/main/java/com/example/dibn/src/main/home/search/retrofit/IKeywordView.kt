package com.example.dibn.src.main.home.search.retrofit

interface IKeywordView {
    fun onGetKeywordSuccess(response: GetItemKeywordResponse)
    fun onGetKeywordFailure(message: String)
}