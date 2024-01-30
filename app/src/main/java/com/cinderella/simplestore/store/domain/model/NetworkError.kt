package com.cinderella.simplestore.store.domain.model

import retrofit2.HttpException
import java.io.IOException

data class NetworkError(val apiError : ApiError , val throwable : Throwable)

enum class ApiError{
    IOError,
    HttpError,
    UnknownError
}

fun Throwable.toNetworkError() : NetworkError {
    return when (this) {
        is HttpException -> {
            NetworkError(ApiError.HttpError, this)
        }
        is IOException -> {
            NetworkError(ApiError.IOError, this)
        }
        else -> {
            NetworkError(ApiError.UnknownError, this)
        }
    }
}