package lmd.pet.weathernew.data.dataSource.weather

import lmd.pet.weathernew.core.network.WeatherNetwork
import lmd.pet.weathernew.data.dataBase.CitiesDataBase
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather
import lmd.pet.weathernew.utils.network.onError
import lmd.pet.weathernew.utils.network.onSuccess
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton


class WeatherDataSource(
    private val network: WeatherNetwork,
    private val dataBase: CitiesDataBase
) {

    suspend fun getCityWeather(cityId: Int): DailyWeather {
        val cityCoord = dataBase.getCitiesDao().getCityById(cityId).coordCity
        network.getDailyWeather(lat = cityCoord[LAT], lon = cityCoord[LON])
            .onSuccess { weahter ->
                return@getCityWeather weahter
            }
            .onError {}
        throw Exception("Error request")
    }

    companion object {
        private const val LAT = 0
        private const val LON = 1
    }
}