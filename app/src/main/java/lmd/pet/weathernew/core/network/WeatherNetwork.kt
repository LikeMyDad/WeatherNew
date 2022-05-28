package lmd.pet.weathernew.core.network

import lmd.pet.weathernew.BuildConfig
import lmd.pet.weathernew.core.base.Network
import lmd.pet.weathernew.utils.WeatherResponse
import lmd.pet.weathernew.data.api.WeatherApi

class WeatherNetwork(private val service: WeatherApi) : Network() {

    suspend fun getDailyWeather(lat: Double, lon: Double): WeatherResponse {
        return makeRequest {
            service.getWeatherDaily(
                appid = BuildConfig.weatherKey,
                exclude = EXCLUDE,
                units = UNITS,
                lat = lat,
                lon = lon
            )
        }
    }

    companion object {
        private const val EXCLUDE = "minutely"
        private const val UNITS = "metric"
    }
}