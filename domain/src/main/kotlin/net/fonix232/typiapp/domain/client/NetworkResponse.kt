package net.fonix232.typiapp.domain.client

sealed class NetworkResponse<T>(val status: Int, open val data: T?) {
    class Success<T>(status: Int, override val data: T): NetworkResponse<T>(status, data)
    class NetworkFailure<T>(): NetworkResponse<T>(-1, null)
    class ServerFailure<T>(status: Int, val response: ErrorResponse): NetworkResponse<T>(status, null)
}
