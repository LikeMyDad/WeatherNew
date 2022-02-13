package lmd.pet.weathernew.data.api

import lmd.pet.weathernew.data.entity.response.cities.Cities
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CitiesApi {

    @GET("/api/records/1.0/search/")
    suspend fun getCities(
        @Query("dataset") dataset: String = DATA_SET,
        @Query("q") query: String,
        @Query("start") page: Int,
        @Query("rows") rows: Int = 30
    ): Response<Cities>

    companion object {
        private const val DATA_SET = "geonames-all-cities-with-a-population-1000"
    }
}