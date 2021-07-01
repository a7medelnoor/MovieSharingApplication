package com.a7medelnoor.moviesharingapplication.util

import okhttp3.ResponseBody

sealed class Resources<out T>{
    data class SUCCESS<out T>(val value: T): Resources<T>()
    data class ERROR(
       val isNetworkError: Boolean,
       val errorCode: Int?,
       val errorBody: ResponseBody?
    ) : Resources<Nothing>()
    object LOADING: Resources<Nothing>()

}