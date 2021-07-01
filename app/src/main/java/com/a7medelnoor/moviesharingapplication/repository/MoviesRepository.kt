package com.a7medelnoor.moviesharingapplication.repository

import com.a7medelnoor.moviesharingapplication.data.network.RemoteDataSource
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    remoteDataSource: RemoteDataSource
) {
    val remoteDataSource = remoteDataSource

}