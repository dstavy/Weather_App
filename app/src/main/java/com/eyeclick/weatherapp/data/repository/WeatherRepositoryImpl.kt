package com.eyeclick.weatherapp.data.repository

import com.eyeclick.weatherapp.data.mappers.toWeatherData
import com.eyeclick.weatherapp.data.remote.WeatherApi
import com.eyeclick.weatherapp.domain.repository.WeatherRepository
import com.eyeclick.weatherapp.domain.util.Resource
import com.eyeclick.weatherapp.domain.weather.WeatherData
import javax.inject.Inject

/**
 * [WeatherApi] repository impl
 *
 * @property api
 */
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(city: String): Resource<WeatherData> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    city = city,
                    apiKey = "24bf78c34dddb721525821bba2a2dfe0"
                ).toWeatherData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}

