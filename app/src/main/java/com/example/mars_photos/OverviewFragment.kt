package com.example.mars_photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mars_photos.databinding.FragmentOverviewBinding
import com.example.mars_photos.databinding.GridViewItemBinding
import com.example.mars_photos.overview.PhotoGridAdapter

class OverviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }

}