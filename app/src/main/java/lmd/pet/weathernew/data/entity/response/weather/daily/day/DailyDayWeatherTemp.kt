package lmd.pet.weathernew.data.entity.response.weather.daily.day

data class DailyDayWeatherTemp (
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
) {
    companion object {
        fun initial() = DailyDayWeatherTemp(
            day = 2.2,
            min = 0.0,
            max = 4.0,
            night = 0.0,
            eve = 4.0,
            morn = 1.0
        )
    }
}