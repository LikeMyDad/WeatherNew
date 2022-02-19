package lmd.pet.weathernew.domain.useCases

import lmd.pet.weathernew.core.base.CoroutineResultUseCase
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.repositories.CitiesRepository
import java.lang.NullPointerException
import javax.inject.Inject

class CitiesInteractor @Inject constructor(
    private val repository: CitiesRepository
): CoroutineResultUseCase<List<CityModel>, CitiesInteractor.Params>() {

    override suspend fun executeOnBackground(params: Params?): List<CityModel> {
        return params?.let {
            repository.getCities()
        } ?: throw NullPointerException("NeedParams")
    }

    data class Params(
        val todo: String
    )
}