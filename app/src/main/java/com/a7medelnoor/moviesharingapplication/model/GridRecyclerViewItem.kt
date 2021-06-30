package com.a7medelnoor.moviesharingapplication.model


sealed class GridRecyclerViewItem {

    class Title(
        val id: Int,
        val title: String
    ): GridRecyclerViewItem()
    class Movies (
        val movie_id: Int,
        val movie_name: String,
        val movie_thumbnail: String,
        val movie_description: String,
        val movie_rating: Int,
    ): GridRecyclerViewItem()
}