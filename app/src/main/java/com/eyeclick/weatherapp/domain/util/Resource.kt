package com.eyeclick.weatherapp.domain.util

/**
 * A class that  holds response data in case of success  or error rin case of failure
 *
 * @param T
 * @property data
 * @property message
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}
