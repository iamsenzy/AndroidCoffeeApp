package com.example.beadando.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}

