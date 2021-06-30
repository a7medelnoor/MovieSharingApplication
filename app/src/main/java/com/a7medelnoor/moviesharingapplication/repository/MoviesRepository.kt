package com.a7medelnoor.moviesharingapplication.repository

import com.a7medelnoor.moviesharingapplication.data.network.MoviesApi
import com.a7medelnoor.moviesharingapplication.data.network.SafeApiCall
import com.a7medelnoor.moviesharingapplication.model.Movies
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val moviesApi: MoviesApi
): SafeApiCall() {
    suspend fun getMovies() = safeApiCall {moviesApi.getMovies() }

}