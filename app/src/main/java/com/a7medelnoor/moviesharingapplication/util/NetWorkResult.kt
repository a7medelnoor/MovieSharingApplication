package com.a7medelnoor.moviesharingapplication.util


sealed class NetWorkResult<T>(
    val data: T? = null,
    val message: String? = null
    ) {
        class SUCCESS<T>(data: T) : NetWorkResult<T>(data)
        class ERROR<T>(message: String?, data: T? = null) : NetWorkResult<T>(data, message)
        class LOADING<T> : NetWorkResult<T>()
}