package lmd.pet.weathernew.data.dataSource.cities

import lmd.pet.weathernew.core.network.CitiesNetwork
import lmd.pet.weathernew.data.dataBase.CitiesDataBase
import lmd.pet.weathernew.data.dataSource.mapper.toModel
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.utils.network.onSuccess
import java.lang.NullPointerException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CitiesDataSource @Inject constructor(
    private val network: CitiesNetwork,
    private val dataBase: CitiesDataBase
) {

    suspend fun getCities(): List<CityModel> {
        return fillDbOrGetQueryCities {
            dataBase.getCitiesDao().getCities()
        }
    }

    private suspend fun <T> fillDbOrGetQueryCities(
        block: suspend () -> T?
    ): T {
        val query = block()
        val isEmpty = if (query is List<*>) {
            query.isEmpty()
        } else {
            query == null
        }
        return if (isEmpty) {
            network.getCities()
                .onSuccess { cities ->
                    cities.citiesRecords.map { it.cityFields.toModel() }
                        .also { dataBase.getCitiesDao().insertCities(*it.toTypedArray()) }
                }
            block() ?: throw NullPointerException()
        } else {
            query!!
        }
    }
}