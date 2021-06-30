package com.a7medelnoor.moviesharingapplication.data.network

import com.a7medelnoor.moviesharingapplication.model.GridRecyclerViewItem
import com.a7medelnoor.moviesharingapplication.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    // get movies
    @GET("movies")
    fun getMovies(): List<GridRecyclerViewItem.Movies>
//    // search movies
//    @GET("query")
//    fun searchMovies(@Query("query") query: String?): Call<Movies>
}