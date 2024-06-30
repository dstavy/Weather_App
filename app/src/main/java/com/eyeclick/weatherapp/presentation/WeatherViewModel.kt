package com.eyeclick.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eyeclick.weatherapp.domain.repository.WeatherRepository
import com.eyeclick.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherData() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            val result = repository.getWeatherData(state.inputCity.trim())

            state = if (result is Resource.Success) {
                state.copy(
                    weatherData = result.data,
                    isLoading = false,
                    error = null
                )
            } else {
                state.copy(
                    weatherData = null,
                    isLoading = false,
                    error = result.message
                )
            }
        }
    }

    fun updateCity(input: String) {
        state = state.copy(
            inputCity = input
        )
    }

}