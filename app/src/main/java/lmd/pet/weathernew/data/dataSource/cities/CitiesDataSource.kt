package lmd.pet.weathernew.data.dataSource.cities

import lmd.pet.weathernew.core.network.WeatherNetwork
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CitiesDataSource @Inject constructor(private val network: WeatherNetwork) {

    fun getWeatherDaily(): DailyWeather {
//        return network.getDailyWeather(0.0, 0.0)
    TODO()
    }
}