package com.example.mars_photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mars_photos.databinding.GridViewItemBinding

class OverviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = GridViewItemBinding.inflate(inflater)
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

}