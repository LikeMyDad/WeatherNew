package lmd.pet.weathernew.domain.useCases.cities

import lmd.pet.weathernew.core.base.coroutine.CoroutineResultUseCase
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.repositories.city.CitiesRepository
import java.lang.NullPointerException

class GetCitiesInteractor(
    private val repository: CitiesRepository
): CoroutineResultUseCase<List<CityModel>, GetCitiesInteractor.Params>() {

    override suspend fun doWork(params: Params?): List<CityModel> {
        return params?.let {
            repository.getCities(page = it.page, query = it.query)
        } ?: throw NullPointerException("Need Params")
    }

    data class Params(
        val query: String,
        val page: Int = 0
    )
}