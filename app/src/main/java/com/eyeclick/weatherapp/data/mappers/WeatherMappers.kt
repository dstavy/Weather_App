package com.eyeclick.weatherapp.data.mappers

import com.eyeclick.weatherapp.data.remote.WeatherDto
import com.eyeclick.weatherapp.domain.weather.WeatherData


fun WeatherDto.toWeatherData(): WeatherData {
    return WeatherData(
        description = weather.first().description,
        icon = "https://openweathermap.org/img/w/${weather.first().icon}.png",
        temperature = main.temp,
        pressure = main.pressure,
        humidity = main.humidity,
        windSpeed = wind.speed,
        city = name
    )
}