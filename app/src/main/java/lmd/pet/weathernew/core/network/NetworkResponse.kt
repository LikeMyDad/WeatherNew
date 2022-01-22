package lmd.pet.weathernew.core.network

sealed class NetworkResponse<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T?): NetworkResponse<T>(data = data)
    class Error<T>(error: Throwable?): NetworkResponse<T>(error = error)
}
