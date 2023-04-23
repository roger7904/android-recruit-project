package com.example.data.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

// This is a sealed class that represents the result of a network request.
sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable? = null) : Result<Nothing>
    object Loading : Result<Nothing>
}

// This extension function converts a Flow<T> to a Flow<Result<T>>.
// It emits a Result.Loading value when the flow starts, then emits a Result.Success value
// when the flow emits a value, and finally emits a Result.Error value when the flow throws an exception.
// This is a very useful extension function that can use in network response state handle.
// It allows you to emit a loading state when the flow starts, and then emit a success or error state
fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .onStart { emit(Result.Loading) }
        .catch { emit(Result.Error(it)) }
}