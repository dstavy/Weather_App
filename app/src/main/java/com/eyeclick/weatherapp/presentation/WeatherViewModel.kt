package com.eyeclick.weatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eyeclick.weatherapp.domain.repository.WeatherRepository
import com.eyeclick.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> = _state.asStateFlow()

    fun onIntent(intent: WeatherIntent) {
        when (intent) {
            is WeatherIntent.Load -> loadWeatherData()
            is WeatherIntent.UpdateCity -> updateCity(intent.updatedCity)
        }
    }

    private fun loadWeatherData() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )
            val result = repository.getWeatherData(_state.value.inputCity.trim())

            _state.value = if (result is Resource.Success) {
                _state.value.copy(
                    weatherData = result.data,
                    isLoading = false,
                    error = null
                )
            } else {
                _state.value.copy(
                    weatherData = null,
                    isLoading = false,
                    error = result.message
                )
            }
        }
    }

    private fun updateCity(updatedCity: String) {
        _state.value = _state.value.copy(
            inputCity = updatedCity
        )
    }

}