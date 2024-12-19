package com.singlepointsol.assignmentpixabay

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    val hits: List<ImageItem>

    data class ImageItem(
        val id: Int,
        val user: String,
        val likes: Int,
        val views: Int,
        val webformatURL: String
    )
}
interface PixabayService {
    @GET("api/")
    suspend fun getImages(
        @Query("key") apiKey: String,
        @Query("q") query: String
    )
}

object ApiClient {
    private const val mainUrl = "https://pixabay.com/"

    val pixabayService: PixabayService by lazy {
        Retrofit.Builder()
            .baseUrl(mainUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixabayService::class.java)
    }
}