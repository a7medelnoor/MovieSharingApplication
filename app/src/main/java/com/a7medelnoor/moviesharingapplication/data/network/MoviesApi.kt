package com.a7medelnoor.moviesharingapplication.data.network

import com.a7medelnoor.moviesharingapplication.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    // get movies
    @GET("users/143961235/videos")
    fun getMovies(): Call<Movies>
    // search movies
    @GET("query")
    fun searchMovies(@Query("query") query: String?): Call<Movies>
}