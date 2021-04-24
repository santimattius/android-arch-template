package com.santimattius.template.core

sealed class Result<out T : Any> {

    companion object {

        fun <T : Any> success(out: T) = Success(out)

        fun failure(exception: Throwable) = Failure(exception)
    }
}

data class Success<T : Any> internal constructor(val out: T) : Result<T>()

data class Failure(val exception: Throwable) : Result<Nothing>()