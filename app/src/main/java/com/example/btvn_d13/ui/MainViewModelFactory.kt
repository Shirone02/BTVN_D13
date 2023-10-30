package com.example.btvn_d13.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.btvn_d13.repositories.ForecastRepository

class MainViewModelFactory(private var forecastRepository: ForecastRepository, val application: Application):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(forecastRepository, application) as T
    }
}