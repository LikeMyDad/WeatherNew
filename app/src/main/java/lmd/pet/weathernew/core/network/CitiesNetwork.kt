package lmd.pet.weathernew.core.network

import lmd.pet.weathernew.utils.CitiesResponse
import lmd.pet.weathernew.utils.Network
import lmd.pet.weathernew.data.api.CitiesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CitiesNetwork @Inject constructor(private val service: CitiesApi) : Network() {

    suspend fun getCities(): CitiesResponse {
        return makeRequest {
            service.getCities(
                page = 0,
                query = ""
            )
        }
    }

}