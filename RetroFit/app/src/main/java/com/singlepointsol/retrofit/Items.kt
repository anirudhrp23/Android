package com.singlepointsol.retrofit

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: String,

    @SerializedName("title")
    val title: String,
)
