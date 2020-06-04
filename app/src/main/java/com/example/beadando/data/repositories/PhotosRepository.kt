package com.example.beadando.data.repositories

import com.example.beadando.data.network.PhotosApi

class PhotosRepository(
    private val api: PhotosApi
) : SafeApiRequest() {

    suspend fun getPhotos() = apiRequest { api.getPhotos() }

}