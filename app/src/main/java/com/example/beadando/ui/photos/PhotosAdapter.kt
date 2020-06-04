package com.example.beadando.ui.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando.R
import com.example.beadando.data.models.Photos
import com.example.beadando.databinding.RecyclerviewPhotosBinding

class PhotosAdapter (
    private val photos: List<Photos>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    override fun getItemCount() = photos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PhotosViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_photos,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.recyclerviewPhotosBinding.photo = photos[position]
        holder.recyclerviewPhotosBinding.moreButton.setOnClickListener {
            listener.onRecyclerViewItemClick(
                holder.recyclerviewPhotosBinding.moreButton,
                photos[position]
            )
        }
    }

    inner class PhotosViewHolder(
        val recyclerviewPhotosBinding: RecyclerviewPhotosBinding
    ) : RecyclerView.ViewHolder(recyclerviewPhotosBinding.root)


}