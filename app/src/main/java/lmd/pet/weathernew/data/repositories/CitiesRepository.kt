package lmd.pet.weathernew.data.repositories

import lmd.pet.weathernew.data.entity.dao.cities.CityModel

interface CitiesRepository {
    suspend fun getCities(page: Int, query: String): List<CityModel>
    suspend fun setCityWeather(id: Int, isShowCityWeather: Boolean)
}