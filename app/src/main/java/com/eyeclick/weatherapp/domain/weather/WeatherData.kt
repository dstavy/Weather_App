package com.eyeclick.weatherapp.domain.weather

data class WeatherData(
    val description: String,
    val icon: String,
    val temperature: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Double,
    val city: String
)
