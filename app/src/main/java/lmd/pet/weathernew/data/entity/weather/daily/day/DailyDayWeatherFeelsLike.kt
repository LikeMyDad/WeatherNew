package lmd.pet.weathernew.data.entity.weather.daily.day

import java.io.Serializable

data class DailyDayWeatherFeelsLike (
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
): Serializable