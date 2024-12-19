package com.singlepointsol.assignmentpictureapi

import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("https://pixabay.com/photos/mountain-mist-landscape-nature-5195052/")
    suspend fun getMountain(): Response<MountainResponse>

}