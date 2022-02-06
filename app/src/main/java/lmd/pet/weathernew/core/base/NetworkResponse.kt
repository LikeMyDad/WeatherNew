package lmd.pet.weathernew.core.base

sealed class NetworkResponse<T>(
    val data: T? = null,
    val error: String? = null
) {
    class Success<T>(data: T?): NetworkResponse<T>(data = data)
    class Error<T>(error: String?): NetworkResponse<T>(error = error)
}
