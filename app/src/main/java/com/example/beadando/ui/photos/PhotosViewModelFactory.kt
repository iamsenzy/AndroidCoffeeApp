package com.example.beadando.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beadando.data.repositories.PhotosRepository

@Suppress("UNCHECKED_CAST")
class PhotosViewModelFactory(
    private val repository: PhotosRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotosViewModel(repository) as T
    }

}