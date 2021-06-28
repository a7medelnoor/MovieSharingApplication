package com.a7medelnoor.moviesharingapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    @SerializedName("id")
    val id: Int,
    @SerializedName("movie_image")
    val pictures: Int,
    @SerializedName("movie_name")
    val name: String?,
    @SerializedName("movie_description")
    val description: String?,
):Parcelable