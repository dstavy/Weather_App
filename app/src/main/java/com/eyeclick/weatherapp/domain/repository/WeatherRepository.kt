package com.eyeclick.weatherapp.domain.repository

import com.eyeclick.weatherapp.domain.util.Resource
import com.eyeclick.weatherapp.domain.weather.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(city: String): Resource<WeatherData>
}