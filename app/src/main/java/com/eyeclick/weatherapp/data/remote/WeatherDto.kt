package com.eyeclick.weatherapp.data.remote

data class WeatherDto(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String, // stations
    val main: Main,
    val visibility: Int, // 10000
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int, // 1719734528
    val sys: Sys,
    val timezone: Int, // 3600
    val id: Int, // 2643743
    val name: String, // London
    val cod: Int // 200
)