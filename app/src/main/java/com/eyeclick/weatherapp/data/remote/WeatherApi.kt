package com.eyeclick.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * retrofit openweathermap api interface
 *
 */
interface WeatherApi {

    /**
     * Get weather data
     *
     * @param city
     * @param apiKey
     * @return
     */
    @GET("data/2.5/weather?units=metric")
    suspend fun getWeatherData(
        @Query("q") city: String,
        @Query("APPID") apiKey: String,
    ): WeatherDto
}