package com.eyeclick.weatherapp.presentation

sealed class WeatherIntent {
    data object Load : WeatherIntent()
    data class UpdateCity(val updatedCity: String) : WeatherIntent() // Intent with data
}