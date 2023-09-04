package com.example.urlinteraction

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val okHttpClient = OkHttpClient()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.coincap.io/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}