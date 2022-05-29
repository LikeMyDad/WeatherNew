package lmd.pet.weathernew.data.entity.response.weather

import lmd.pet.weathernew.data.entity.response.weather.current.CurrentWeather
import lmd.pet.weathernew.data.entity.response.weather.daily.day.DailyDayWeather
import lmd.pet.weathernew.data.entity.response.weather.daily.hour.HourlyWeather
import com.google.gson.annotations.SerializedName

data class DailyWeather (
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val current: CurrentWeather,
    val daily: List<DailyDayWeather>,
    val hourly: List<HourlyWeather>,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int
) {
    companion object {
        fun initial() = DailyWeather(
            lat = 2.2,
            lon = 2.2,
            timezone = "Europe/Paris",
            current = CurrentWeather.initial(),
            daily = listOf(DailyDayWeather.initial()),
            hourly = listOf(HourlyWeather.initial()),
            timezoneOffset = 3
        )
    }
}