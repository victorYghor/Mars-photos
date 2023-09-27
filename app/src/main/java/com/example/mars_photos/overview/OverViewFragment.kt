package com.example.mars_photos.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mars_photos.databinding.FragmentOverviewBinding

class OverViewFragment : Fragment() {
    private val viewModel: OverViewModel by viewModels<OverViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOverviewBinding.inflate(inflater)
        // allow the data binding observe the data in the viewmodel respect the lifecycle
        binding.lifecycleOwner = this
        // insert the viewModel in the biding
        binding.overViewModel = viewModel
        // set the adapter to the photosGrid
        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }

}