package lmd.pet.weathernew.domain.useCases.cities

import lmd.pet.weathernew.core.base.coroutine.CoroutineUseCase
import lmd.pet.weathernew.data.repositories.city.CitiesRepository

class SetStateToShowCityWeatherInteractor(
    private val repository: CitiesRepository
) : CoroutineUseCase<SetStateToShowCityWeatherInteractor.Params>() {

    override suspend fun doWork(params: Params?) {
        params?.let {
            repository.setCityWeather(id = it.cityId, isShowCityWeather = it.isShowWeather)
        }
    }

    data class Params(
        val cityId: Int,
        val isShowWeather: Boolean
    )
}