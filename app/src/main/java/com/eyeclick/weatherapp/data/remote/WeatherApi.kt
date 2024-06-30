package com.eyeclick.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather?units=metric")
    suspend fun getWeatherData(
        @Query("q") city: String,
        @Query("APPID") apiKey: String,
    ): WeatherDto
}