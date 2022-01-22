package lmd.pet.weathernew.data.entity.weather.daily.day

import java.io.Serializable

data class DailyDayWeatherTemp (
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
): Serializable