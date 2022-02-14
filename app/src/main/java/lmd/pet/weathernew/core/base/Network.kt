package lmd.pet.weathernew.core.base

import lmd.pet.weathernew.utils.network.NetworkResponse
import retrofit2.Response
import java.lang.Exception
import java.lang.NullPointerException

abstract class Network {
    protected inline fun <reified T> makeRequest(
        responseBody: () -> Response<T>
    ): NetworkResponse<T> {
        return try {
            val response = responseBody()
            if (response.isSuccessful) {
                NetworkResponse.Success(
                    response.body() ?: throw NullPointerException()
                )
            } else {
                NetworkResponse.Error(
                    "${response.code()} ${response.message()}"
                )
            }
        } catch (e: Exception) {
            NetworkResponse.Error(e.message ?: e.toString())
        }
    }

}