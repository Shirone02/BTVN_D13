package com.example.btvn_d13.models


import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<>,
    @SerializedName("message")
    val message: Int
)