package lmd.pet.weathernew.domain.useCases.cities

import lmd.pet.weathernew.core.base.coroutine.CoroutineResultUseCase
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.repositories.city.CitiesRepository

class GetCitiesWeatherInteractor(
    private val repository: CitiesRepository
): CoroutineResultUseCase<List<CityModel>, Unit>() {
    override suspend fun executeOnBackground(params: Unit?): List<CityModel> {
        return repository.getCitiesWeather()
    }
}