package lmd.pet.weathernew.data.dataSource.cities

import lmd.pet.weathernew.core.network.CitiesNetworkSource
import lmd.pet.weathernew.data.dataSource.toModel
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.utils.network.onSuccess

class CitiesDataSource(
    private val network: CitiesNetworkSource,
    private val dataBase: CitiesDataBase
) {

    suspend fun getCities(page: Int, query: String): List<CityModel> {
        return fillDbOrGetQueryCities(page = page, query = query) {
            if (query.isBlank()) {
                dataBase.getCities()
            } else {
                dataBase.getCitiesBySearchQuery(searchQuery = query, 30, page)
            }
        }
    }

    suspend fun setStateToShowCityWeather(id: Int, isShowCityWeather: Boolean) {
        dataBase.setStateShowCityWeatherById(id, isShowCityWeather)
    }

    suspend fun getCitiesWeather(): List<CityModel> {
        return dataBase.getCitiesWeather()
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
                        .also {
                            dataBase.insertCities(it)
                        }
                }
            block() ?: throw NullPointerException()
        } else {
            queryBlock!!
        }
    }
}