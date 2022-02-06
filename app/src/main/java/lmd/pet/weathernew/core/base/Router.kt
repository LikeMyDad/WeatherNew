package lmd.pet.weathernew.core.base

import retrofit2.Response

abstract class Router {

    inline fun <reified T> makeRequest(
        responseBody: () -> Response<T>
    ): NetworkResponse<T> {
        val response = responseBody()
        return if (response.isSuccessful) {
            NetworkResponse.Success(response.body())
        } else {
            NetworkResponse.Error(response.errorBody().toString())
        }
    }

}