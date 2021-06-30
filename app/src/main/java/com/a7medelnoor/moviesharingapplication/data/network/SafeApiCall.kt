package com.a7medelnoor.moviesharingapplication.data.network

import android.content.res.Resources
import retrofit2.HttpException

open class SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): com.a7medelnoor.moviesharingapplication.util.Resources<T> {
        return try {
            com.a7medelnoor.moviesharingapplication.util.Resources.SUCCESS(apiCall.invoke())
        }catch (throwable: Throwable){
            when(throwable){
                is HttpException -> {
                    com.a7medelnoor.moviesharingapplication.util.Resources.ERROR(false, throwable.code(),throwable.response()?.errorBody())
                }
                else -> {
                    com.a7medelnoor.moviesharingapplication.util.Resources.ERROR(true,null,null)
                }
            }
        }
    }
}