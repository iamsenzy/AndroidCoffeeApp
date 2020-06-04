package com.example.beadando.data.network

import com.example.beadando.data.models.Photos
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PhotosApi {
    @GET("photos")
    suspend fun getPhotos() : Response<List<Photos>>


    companion object{
        operator fun invoke() : PhotosApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                .create(PhotosApi::class.java)
        }
    }
}