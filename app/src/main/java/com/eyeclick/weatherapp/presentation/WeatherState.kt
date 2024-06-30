package com.eyeclick.weatherapp.presentation

import com.eyeclick.weatherapp.domain.weather.WeatherData

/**
 * Presentation Weather state
 *
 * @property weatherData
 * @property inputCity
 * @property isLoading
 * @property error
 * @constructor Create init Weather state
 */
data class WeatherState(
    val weatherData: WeatherData? = null,
    val inputCity: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
