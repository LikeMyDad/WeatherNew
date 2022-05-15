package lmd.pet.weathernew.data.repositories.weather

import lmd.pet.weathernew.data.dataSource.weather.WeatherDataSource
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val dataSource : WeatherDataSource
): WeatherRepository {
    override suspend fun getCityWeather(cityId: Int): DailyWeather {
        return try {
            dataSource.getCityWeather(cityId)
        } catch (e: Exception) {
            TODO("Custom exception")
        }
    }
}