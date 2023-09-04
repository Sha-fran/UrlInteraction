package com.example.urlinteraction

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/v2/rates/bitcoin")
    fun getBitcoin():Call<BitcoinResponce>
}