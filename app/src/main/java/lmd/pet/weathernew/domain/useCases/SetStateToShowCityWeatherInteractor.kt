package lmd.pet.weathernew.domain.useCases

import lmd.pet.weathernew.core.base.coroutine.CoroutineUseCase
import lmd.pet.weathernew.data.repositories.CitiesRepository
import javax.inject.Inject

class SetStateToShowCityWeatherInteractor @Inject constructor(
    private val repository: CitiesRepository
): CoroutineUseCase<SetStateToShowCityWeatherInteractor.Params>() {

    override suspend fun executeOnBackground(params: Params?) {
        params?.let {
            repository.setCityWeather(id = it.cityId, isShowCityWeather = it.isShowWeather)
        }
    }

    data class Params(
        val cityId: Int,
        val isShowWeather: Boolean
    )
}