package com.eyeclick.weatherapp.data.remote

data class WeatherDto(
    val coord: CoordDto,
    val weather: List<WeatherMetadataDto>,
    val base: String, // stations
    val main: MainDto,
    val visibility: Int, // 10000
    val wind: Wind,
    val clouds: CloudsDto,
    val dt: Int, // 1719734528
    val sys: SysDto,
    val timezone: Int, // 3600
    val id: Int, // 2643743
    val name: String, // London
    val cod: Int // 200
)