package com.eyeclick.weatherapp.domain.repository

import com.eyeclick.weatherapp.domain.util.Resource
import com.eyeclick.weatherapp.domain.weather.WeatherData

/**
 * Weather repository interface
 *
 */
interface WeatherRepository {
    /**
     * Get weather data
     *
     * @param city
     * @return
     */
    suspend fun getWeatherData(city: String): Resource<WeatherData>
}