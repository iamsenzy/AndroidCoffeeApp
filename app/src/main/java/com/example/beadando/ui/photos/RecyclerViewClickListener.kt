package com.example.beadando.ui.photos

import android.view.View
import com.example.beadando.data.models.Photos

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, photos: Photos)
}