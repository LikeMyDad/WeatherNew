package lmd.pet.weathernew.data.dataSource.cities

import androidx.room.withTransaction
import lmd.pet.weathernew.data.room.CitiesDataBaseRoom
import lmd.pet.weathernew.data.entity.dao.cities.CitiesDao
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

class CitiesDataBase(
    private val dataBaseRoom: CitiesDataBaseRoom
) {
    private val citiesDao: CitiesDao = dataBaseRoom.getCitiesDao()

    suspend fun getCities() = citiesDao.getCities()

    suspend fun getCitiesBySearchQuery(searchQuery: String, maxCitiesCount: Int, page: Int) =
        citiesDao.getCitiesBySearchQuery(searchQuery, maxCitiesCount, maxCitiesCount * page)

    suspend fun insertCities(cities: List<CityModel>) {
        dataBaseRoom.withTransaction {
            citiesDao.insertCities(*cities.toTypedArray())
        }
    }

    suspend fun setStateShowCityWeatherById(id: Int, isShowCityWeather: Boolean) {
        dataBaseRoom.withTransaction {
            citiesDao.setStateShowCityWeatherById(id, isShowCityWeather)
        }
    }

    suspend fun getCitiesWeather() = citiesDao.getCitiesWeather()
}