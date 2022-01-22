package lmd.pet.weathernew.data.entity.weather

import lmd.pet.weathernew.data.entity.weather.current.CurrentWeather
import lmd.pet.weathernew.data.entity.weather.daily.day.DailyDayWeather
import lmd.pet.weathernew.data.entity.weather.daily.hour.HourlyWeather
import com.google.gson.annotations.SerializedName

data class DailyWeatherMain (
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val current: CurrentWeather,
    val daily: List<DailyDayWeather>,
    val hourly: List<HourlyWeather>,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int
)