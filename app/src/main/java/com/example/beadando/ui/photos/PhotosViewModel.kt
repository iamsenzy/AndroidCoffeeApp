package com.example.beadando.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beadando.data.models.Photos
import com.example.beadando.data.repositories.PhotosRepository
import com.example.beadando.util.Coroutines
import kotlinx.coroutines.Job

class PhotosViewModel(
    private val repository: PhotosRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _photos = MutableLiveData<List<Photos>>()
    val photos: LiveData<List<Photos>>
        get() = _photos

    fun getPhotos() {
        job = Coroutines.ioThenMain(
            { repository.getPhotos() },
            { _photos.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
