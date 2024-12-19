package com.singlepointsol.assignmentpictureapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private const val mainUrl = "https://pixabay.com/api"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(mainUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
