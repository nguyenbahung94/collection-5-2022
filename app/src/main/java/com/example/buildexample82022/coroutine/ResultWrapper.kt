package com.example.buildexample82022.coroutine

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val code: String?,
                            val message: String,
                            val data: Any?) : ResultWrapper<Nothing>()
    object NetworkError : ResultWrapper<Nothing>()
    object NoValue : ResultWrapper<Nothing>()
    object Loading : ResultWrapper<Nothing>()
}