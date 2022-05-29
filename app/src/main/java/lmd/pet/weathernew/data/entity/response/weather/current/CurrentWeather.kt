package lmd.pet.weathernew.data.entity.response.weather.current

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    val date: Long,
    val sunrise: Int,
    val sunset: Int,
    val temperature: Double,
    val pressure: Double,
    val humidity: Int,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("dew_point")
    val dewPoint: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("weather")
    val weatherIcon: List<WeatherIcon>
) {
    companion object {
        fun initial() = CurrentWeather(
            date = 1653714100,
            sunrise = 1653702100,
            sunset = 1653729100,
            temperature = 12.2,
            pressure = 320.2,
            humidity = 0,
            uvi = 2.2,
            clouds = 1,
            visibility = 92,
            feelsLike = 12.2,
            dewPoint = 2.3,
            windDeg = 19,
            windSpeed = 12.2,
            weatherIcon = listOf(WeatherIcon.initial())
        )
    }
}