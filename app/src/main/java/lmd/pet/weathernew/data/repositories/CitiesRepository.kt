package lmd.pet.weathernew.data.repositories

import lmd.pet.weathernew.data.dataSource.cities.CitiesDataSource
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import java.lang.Exception
import javax.inject.Inject

class CitiesRepository @Inject constructor(
    private val dataSource: CitiesDataSource
) {
    suspend fun getCities(): List<CityModel> {
        return try {
            dataSource.getCities()
        } catch (e: Exception) {
            TODO("Custom exception")
        }
    }
}