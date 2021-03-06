package lmd.pet.weathernew.data.dataSource.cities

import lmd.pet.weathernew.core.network.CitiesNetwork
import lmd.pet.weathernew.data.dataBase.CitiesDataBase
import lmd.pet.weathernew.data.dataSource.toModel
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.utils.network.onSuccess

class CitiesDataSource(
    private val network: CitiesNetwork,
    private val dataBase: CitiesDataBase
) {

    suspend fun getCities(page: Int, query: String): List<CityModel> {
        return fillDbOrGetQueryCities(page = page, query = query) {
            if (query.isBlank()) {
                dataBase.getCitiesDao().getCities()
            } else {
                dataBase.getCitiesDao().getCitiesBySearchQuery(searchQuery = query)
            }
        }
    }

    suspend fun setStateToShowCityWeather(id: Int, isShowCityWeather: Boolean) {
        dataBase.getCitiesDao().setStateShowCityWeatherById(id, isShowCityWeather)
    }

    suspend fun getCitiesWeather(): List<CityModel> {
        return dataBase.getCitiesDao().getCitiesWeather()
    }

    private suspend fun <T> fillDbOrGetQueryCities(
        page: Int,
        query: String,
        block: suspend () -> T?
    ): T {
        val queryBlock = block()
        val isEmpty = if (queryBlock is List<*>) {
            queryBlock.isEmpty()
        } else {
            queryBlock == null
        }
        return if (isEmpty) {
            network.getCities(page = page, query = query)
                .onSuccess { cities ->
                    cities.citiesRecords.map { it.cityFields.toModel() }
                        .also { dataBase.getCitiesDao().insertCities(*it.toTypedArray()) }
                }
            block() ?: throw NullPointerException()
        } else {
            queryBlock!!
        }
    }
}