package lmd.pet.weathernew.data.entity.response.weather.daily.day

import com.google.gson.annotations.SerializedName
import lmd.pet.weathernew.data.entity.response.weather.current.WeatherIcon

data class DailyDayWeather (
    val date: Long,
    val sunrise: Int,
    val sunset: Int,
    val pressure: Int,
    val humidity: Int,
    val weather: List<WeatherIcon>,
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
) {
    companion object {
        fun initial() = DailyDayWeather(
            date = 1653714100,
            sunrise = 1653702100,
            sunset = 1653729100,
            pressure = 320,
            humidity = 0,
            uvi = 2.2,
            clouds = 1,
            feelsLike = DailyDayWeatherFeelsLike.initial(),
            dewPoint = 2.3,
            windDeg = 19.2,
            windSpeed = 12.2,
            weather = listOf(WeatherIcon.initial()),
            temperature = DailyDayWeatherTemp.initial(),
            pop = 2.0
        )
    }
}