package com.example.weather.data.response.weather.daily.hour

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class HourlyWeather (
    val dt: Int,
    val pressure: Int,
    val humidity: Int,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val weather: List<HourlyWeatherIcon>,
    val pop: Double,
    @SerializedName("temp")
    val temperature: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("wind_gust")
    val windGust: Double,
    @SerializedName("dew_point")
    val dewPoint: Double
): Serializable