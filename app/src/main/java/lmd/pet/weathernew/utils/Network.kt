package lmd.pet.weathernew.utils

import retrofit2.Response
import java.lang.Exception
import java.lang.NullPointerException

abstract class Network {
    inline fun <reified T> makeRequest(
        responseBody: () -> Response<T>
    ): NetworkResponse<T> {
        return try {
            val response = responseBody()
            if (response.isSuccessful) {
                NetworkResponse.Success(
                    response.body() ?: throw NullPointerException()
                )
            } else {
                errorNetwork("${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            errorNetwork(e.message ?: e.toString())
        }
    }

    @PublishedApi
    internal inline fun <reified T> errorNetwork(messageError: String): NetworkResponse<T> =
        NetworkResponse.Error(messageError)
}