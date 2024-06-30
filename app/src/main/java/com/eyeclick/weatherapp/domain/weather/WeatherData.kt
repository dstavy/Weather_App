package com.eyeclick.weatherapp.domain.weather

/**
 * Domain Weather data class
 *
 * @property description
 * @property icon
 * @property temperature
 * @property pressure
 * @property humidity
 * @property windSpeed
 * @property city
 * @constructor Create empty Weather data
 */
data class WeatherData(
    val description: String,
    val icon: String,
    val temperature: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Double,
    val city: String
)
