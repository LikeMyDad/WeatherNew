package lmd.pet.weathernew.data.entity.weather.daily.hour

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HourlyWeatherIcon (
    val id: Int,
    val description: String,
    val icon: String,
    @SerializedName("main")
    val mainWeatherIcon: String
): Serializable