package lmd.pet.weathernew.data.entity.response.weather.current

import com.google.gson.annotations.SerializedName

data class CurrentWeatherIcon (
    val id: Int,
    val description: String,
    val icon: String,
    @SerializedName("main")
    val mainWeatherIcon: String
) {
    companion object {
        fun initial() = CurrentWeatherIcon(
            id = 2,
            description = "asd",
            icon = "02d",
            mainWeatherIcon = "02d"
        )
    }
}