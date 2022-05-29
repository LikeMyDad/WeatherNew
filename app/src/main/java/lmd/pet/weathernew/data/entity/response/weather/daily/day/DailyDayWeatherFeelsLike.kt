package lmd.pet.weathernew.data.entity.response.weather.daily.day

data class DailyDayWeatherFeelsLike (
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
) {
    companion object {
        fun initial() = DailyDayWeatherFeelsLike(
            day = 2.2,
            night = -2.2,
            eve = 3.0,
            morn = 1.0
        )
    }
}