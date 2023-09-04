package com.example.urlinteraction

data class BitcoinResponce(val data:Data)

data class Data(
    val id:String,
    val symbol:String,
    val currencySymbol:String,
    val type:String,
    val rateUsd:String
)
