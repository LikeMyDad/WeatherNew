package lmd.pet.weathernew.data.dataSource.cities

import lmd.pet.weathernew.core.network.WeatherNetwork
import lmd.pet.weathernew.data.dataBase.CitiesDataBase
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather
import lmd.pet.weathernew.utils.network.isSuccess
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CitiesDataSource @Inject constructor(
    private val network: WeatherNetwork,
    private val dataBase: CitiesDataBase
) {

    fun getCities(lat: Double, lon: Double): List<CityModel> {

    }

    private fun <T>fillDbOrGetQuery(
        lat: Double,
        lon: Double,
        block: () -> T?
    ): T {
        val query = block()
        val isEmpty = if (query is List<*>) {
            query.isEmpty()
        } else {
            query == null
        }

        return if (isEmpty) {
            network.getDailyWeather(lat, lon)
                .isSuccess {

                }

        } else {
            query!!
        }
    }
}