package com.example.beadando.ui.start

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.beadando.R

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)

        val button_to_coffe: Button = view!!.findViewById(R.id.button_to_coffee_fragment) as Button
        button_to_coffe.setOnClickListener(View.OnClickListener {
            val navController =
                Navigation.findNavController(activity!!, R.id.fragment)
            navController.navigate(R.id.coffee)
        })

        val button_to_photos: Button = view!!.findViewById(R.id.button_to_photos_fragment) as Button
        button_to_photos.setOnClickListener(View.OnClickListener {
            val navController =
                Navigation.findNavController(activity!!, R.id.fragment)
            navController.navigate(R.id.photosFragment)
        })

    }

}
