package com.a7medelnoor.moviesharingapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Movies(
@SerializedName("results")
internal val results: List<Results>
)