package com.example.buildexample82022.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T?
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            val result = apiCall()
            if (result == null || result is Unit) {
                ResultWrapper.NoValue
            } else {
                ResultWrapper.Success(result)
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            when (throwable) {
                is NetException -> {
                    ResultWrapper.GenericError(
                        throwable.code,
                        throwable.message ?: "Error",
                        throwable.serverMessage
                    )
                }
                is HttpException -> {
                    val code = "http ${throwable.code()}"
                    ResultWrapper.GenericError(code, throwable.message(), null)
                }
                is IOException -> {
                    ResultWrapper.NetworkError
                }
                else -> {
                    ResultWrapper.GenericError(null, throwable.message ?: "unknown", null)
                }
            }
        }
    }
}

class NetException(val code: String, message: String?, val serverMessage: String?) : Exception(message)

