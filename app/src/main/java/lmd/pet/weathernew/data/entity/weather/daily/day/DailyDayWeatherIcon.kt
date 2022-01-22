package lmd.pet.weathernew.data.entity.weather.daily.day

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DailyDayWeatherIcon(
    val id: Int,
    val description: String,
    val icon: String,
    @SerializedName("main")
    val mainWeatherIcon: String
): Serializable