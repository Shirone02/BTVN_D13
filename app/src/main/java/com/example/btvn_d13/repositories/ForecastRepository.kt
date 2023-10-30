package com.example.btvn_d13.repositories

import com.example.btvn_d13.api.RetrofitClient
import com.example.btvn_d13.utils.Constants

class ForecastRepository {
    suspend fun getWeatherForecastByCityName(cityName: String) =
        RetrofitClient.getForecastApi.getWeatherForecastByCityName(cityName, Constants.API_KEY)
}