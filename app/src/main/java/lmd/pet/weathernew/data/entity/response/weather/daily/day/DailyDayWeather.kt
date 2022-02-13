package lmd.pet.weathernew.data.entity.response.weather.daily.day

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DailyDayWeather (
    val dt: Int,
    val sunrise: Int,
    val sunset: Int,
    val pressure: Int,
    val humidity: Int,
    val weather: List<DailyDayWeatherIcon>,
    val clouds: Int,
    val pop: Double,
    val uvi: Double,
    @SerializedName("temp")
    val temperature: DailyDayWeatherTemp,
    @SerializedName("feels_like")
    val feelsLike: DailyDayWeatherFeelsLike,
    @SerializedName("dew_point")
    val dewPoint: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDeg: Double
): Serializable