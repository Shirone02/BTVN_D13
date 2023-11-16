package com.example.btvn_d13.api

import com.example.btvn_d13.models.WeatherForecastResponse
import com.example.btvn_d13.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET(Constants.FORECAST_URL)
    suspend fun getWeatherForecastByCityName(
        @Query("q") cityName:String,
        @Query("appid") apiKey: String,
        @Query("lang") lang:String? = "en"
    ): Response<WeatherForecastResponse>

}