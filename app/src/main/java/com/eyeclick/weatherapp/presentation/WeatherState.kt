package com.eyeclick.weatherapp.presentation

import com.eyeclick.weatherapp.domain.weather.WeatherData

data class WeatherState(
    val weatherData: WeatherData? = null,
    val inputCity: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
