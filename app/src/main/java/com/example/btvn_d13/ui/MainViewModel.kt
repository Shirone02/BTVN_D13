package com.example.btvn_d13.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.btvn_d13.api.response.BaseResponse
import com.example.btvn_d13.models.WeatherForecastResponse
import com.example.btvn_d13.repositories.ForecastRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(val forecastRepository: ForecastRepository, application: Application):AndroidViewModel(application) {

    val weatherForecastResult:MutableLiveData<BaseResponse<WeatherForecastResponse>> = MutableLiveData()

    var weatherForecastResponse:WeatherForecastResponse?= null

    fun getWeatherForecastByCityName(cityName:String){
        viewModelScope.launch {
            weatherForecastResult.postValue(BaseResponse.Loading())
            val response = forecastRepository.getWeatherForecastByCityName(cityName)
            weatherForecastResult.postValue(handleWeatherForecastResponse(response))
        }
    }

    private fun handleWeatherForecastResponse(response: Response<WeatherForecastResponse>):
            BaseResponse<WeatherForecastResponse>{
        if(response.isSuccessful && response.code() == 200){
            response.body()?.let {  it ->
                weatherForecastResponse = it
                return BaseResponse.Success(it)

            }
        }
        return BaseResponse.Error(null, response.message())
    }
}