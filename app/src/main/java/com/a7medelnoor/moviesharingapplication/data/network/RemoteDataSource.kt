package com.a7medelnoor.moviesharingapplication.data.network

import com.a7medelnoor.moviesharingapplication.model.Movies
import com.a7medelnoor.moviesharingapplication.model.Results
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val moviesApi: MoviesApi
) {
    suspend fun getMovies(queries: Map<String, String>) :Response<Movies>{
        return moviesApi.getMovies(queries)
    }
}
