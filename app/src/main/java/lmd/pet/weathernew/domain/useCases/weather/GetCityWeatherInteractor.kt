package lmd.pet.weathernew.domain.useCases.weather

import lmd.pet.weathernew.core.base.coroutine.CoroutineResultUseCase
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather
import lmd.pet.weathernew.data.repositories.weather.WeatherRepository

class GetCityWeatherInteractor(
    private val repository: WeatherRepository
): CoroutineResultUseCase<DailyWeather, GetCityWeatherInteractor.Params>() {

    override suspend fun doWork(params: Params?): DailyWeather {
        return params?.let {
            repository.getCityWeather(cityId = it.cityId)
        } ?: throw Exception("No params")
    }

    data class Params(
        val cityId: Int
    )
}