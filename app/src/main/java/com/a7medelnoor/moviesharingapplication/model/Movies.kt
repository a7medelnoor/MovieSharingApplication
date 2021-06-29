package com.a7medelnoor.moviesharingapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    @SerializedName("user_id")
    val user_id: Int,
    @SerializedName("video_id")
    val video_id: Int,
    @SerializedName("movie_image")
    val pictures: Int,
    @SerializedName("movie_name")
    val name: String?,
    @SerializedName("movie_description")
    val description: String?,
    @SerializedName("query")
    val query: String?
):Parcelable