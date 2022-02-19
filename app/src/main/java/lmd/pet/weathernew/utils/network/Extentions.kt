package lmd.pet.weathernew.utils.network

inline fun <T>NetworkResponse<T>.onSuccess(block: (T) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Success<T>) {
        data?.let(block)
    }
    return this
}

inline fun <T>NetworkResponse<T>.onError(block: (messageError: String) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Error<T>) {
        error?.let(block)
    }
    return this
}