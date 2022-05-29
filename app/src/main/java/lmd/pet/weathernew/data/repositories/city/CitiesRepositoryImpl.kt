package lmd.pet.weathernew.data.repositories.city

import lmd.pet.weathernew.data.dataSource.cities.CitiesDataSource
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

class CitiesRepositoryImpl(
    private val dataSource: CitiesDataSource
) : CitiesRepository {
    override suspend fun getCities(page: Int, query: String): List<CityModel> {
        return try {
            dataSource.getCities(page, query)
        } catch (e: Exception) {
            TODO("Custom exception")
        }
    }

    override suspend fun setCityWeather(id: Int, isShowCityWeather: Boolean) {
        return try {
            dataSource.setStateToShowCityWeather(id, isShowCityWeather)
        } catch (e: Exception) {
            TODO("Custom exception")
        }
    }

    override suspend fun getCitiesWeather(): List<CityModel> {
        return try {
            dataSource.getCitiesWeather()
        } catch (e: Exception) {
            TODO("Custom exception")
        }
    }
}