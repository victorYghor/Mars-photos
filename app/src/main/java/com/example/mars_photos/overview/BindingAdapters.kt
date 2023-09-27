package com.example.mars_photos.overview

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mars_photos.R
import com.example.mars_photos.network.MarsPhoto

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.baseline_broken_image_24)
        }
    }

    @BindingAdapter("caseData")
    fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsPhoto>? ) {
        val adapter = recyclerView.adapter as PhotoGridAdapter
        adapter.submitList(data)
    }
}