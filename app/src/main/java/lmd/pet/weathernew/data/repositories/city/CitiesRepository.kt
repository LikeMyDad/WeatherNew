package lmd.pet.weathernew.data.repositories.city

import lmd.pet.weathernew.data.entity.dao.cities.CityModel

interface CitiesRepository {
    suspend fun getCities(page: Int, query: String): List<CityModel>
    suspend fun setCityWeather(id: Int, isShowCityWeather: Boolean)
    suspend fun getCitiesWeather(): List<CityModel>
}