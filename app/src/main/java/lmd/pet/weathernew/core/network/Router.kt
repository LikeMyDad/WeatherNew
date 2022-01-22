package lmd.pet.weathernew.core.network

abstract class Router {

    suspend inline fun <reified T, reified U> makeRequest(
        responseBody: () -> Result<T>
    ): NetworkResponse<T> {
        val response = responseBody()
        return if (response.isSuccess) {
            response.getOrElse { exception -> NetworkResponse.Error(exception) }
            NetworkResponse.Success(response.getOrNull())
        } else {
            NetworkResponse.Error(response.exceptionOrNull())
        }
    }

}