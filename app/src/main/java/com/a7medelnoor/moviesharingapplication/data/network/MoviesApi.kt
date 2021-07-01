package com.a7medelnoor.moviesharingapplication.data.network

import com.a7medelnoor.moviesharingapplication.model.Movies
import com.a7medelnoor.moviesharingapplication.model.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MoviesApi {

    // get movies
    @GET("movies")
    suspend fun getMovies(
        @QueryMap queries: Map<String, String>): Response<Movies>
//    // search movies
//    @GET("query")
//    fun searchMovies(@Query("query") query: String?): Call<Movies>
}