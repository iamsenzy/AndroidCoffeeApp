package com.example.beadando.ui.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beadando.R
import com.example.beadando.data.models.Photos
import com.example.beadando.data.network.PhotosApi
import com.example.beadando.data.repositories.PhotosRepository
import kotlinx.android.synthetic.main.photos_fragment.*

class PhotosFragment : Fragment(), RecyclerViewClickListener{

    private lateinit var factory: PhotosViewModelFactory
    private lateinit var viewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = PhotosApi()
        val repository = PhotosRepository(api)

        factory = PhotosViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(PhotosViewModel::class.java)

        viewModel.getPhotos()

        viewModel.photos.observe(viewLifecycleOwner, Observer { photos ->
            recycler_view_photos.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = PhotosAdapter(photos, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, photos: Photos) {
        when(view.id){
            R.id.more_button -> {
                Toast.makeText(requireContext(), "More Button Clicked on ${photos.title}", Toast.LENGTH_LONG).show()
            }

        }
    }
}
