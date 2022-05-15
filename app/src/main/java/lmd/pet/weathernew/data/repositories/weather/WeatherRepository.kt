package lmd.pet.weathernew.data.repositories.weather

import lmd.pet.weathernew.data.entity.response.weather.DailyWeather

interface WeatherRepository {
    suspend fun getCityWeather(cityId: Int) : DailyWeather
}