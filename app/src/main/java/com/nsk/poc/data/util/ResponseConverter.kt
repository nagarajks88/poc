package com.nsk.poc.data.util

import retrofit2.Response

suspend fun <T: Any> handleRequest(requestFunc: suspend () -> Response<T>): Resource<T> {
    requestFunc.invoke().apply {
        if (isSuccessful) {
            body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message())
    }
}