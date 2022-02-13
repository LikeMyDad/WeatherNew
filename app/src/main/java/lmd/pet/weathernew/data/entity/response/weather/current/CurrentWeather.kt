package lmd.pet.weathernew.data.entity.response.weather.current

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CurrentWeather(
    val dt: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Double,
    val pressure: Double,
    val humidity: Int,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("dew_point")
    val dewPoint: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("weather")
    val weatherIcon: List<CurrentWeatherIcon>
    ): Serializable