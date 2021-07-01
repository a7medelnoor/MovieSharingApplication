package com.a7medelnoor.moviesharingapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Results(
    @SerializedName("movie_id")
    val movie_id: String,
    @SerializedName("movie_name")
    val movie_name: String,
    @SerializedName("movie_thumbnail")
    val movie_thumbnail: String,
    @SerializedName("movie_description")
    val movie_description: String,
    @SerializedName("movie_rating")
    val movie_rating: Int,
)