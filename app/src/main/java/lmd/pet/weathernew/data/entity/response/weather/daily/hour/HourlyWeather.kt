package lmd.pet.weathernew.data.entity.response.weather.daily.hour

import com.google.gson.annotations.SerializedName
import lmd.pet.weathernew.data.entity.response.weather.current.WeatherIcon


data class HourlyWeather(
    val date: Long,
    val pressure: Int,
    val humidity: Int,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val weather: List<WeatherIcon>,
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
) {
    companion object {
        fun initial() = HourlyWeather(
            date = 1653714100,
            pressure = 320,
            humidity = 0,
            uvi = 2.2,
            clouds = 1,
            feelsLike = 2.0,
            dewPoint = 2.3,
            windDeg = 19,
            windSpeed = 12.2,
            weather = listOf(WeatherIcon.initial()),
            temperature = 2.3,
            pop = 2.0,
            visibility = 3,
            windGust = 9.0
        )
    }
}