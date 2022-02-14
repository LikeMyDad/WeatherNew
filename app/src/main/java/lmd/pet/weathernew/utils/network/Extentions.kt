package lmd.pet.weathernew.utils.network

inline fun <T>NetworkResponse<T>.isSuccess(block: (T) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Success<T>) {
        block(this.data!!)
    }
    return this
}

inline fun <T>NetworkResponse<T>.isError(block: (messageError: String) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Error<T>) {
        block(this.error!!)
    }
    return this
}