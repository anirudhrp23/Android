package com.singlepointsol.assignmentpictureapi

import com.google.gson.annotations.SerializedName

data class Mountain(
@SerializedName("webformatURL")
val mountainImage: String,
@SerializedName("user")
val user: String,
@SerializedName("views")
val views: Int,
@SerializedName("downloads")
val downloads: Int,
@SerializedName("likes")
val likes: Int
)

data class MountainResponse(
    @SerializedName("hits")
    val hits: List<Mountain>
)

