package com.example.dibn.src.main.owner

interface InftView {
    fun onPostNftSuccess(response: PostNftResponse)
    fun onPostNftFailure(message: String)
}