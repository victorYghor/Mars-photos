package com.example.mars_photos.overview

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mars_photos.R
import com.example.mars_photos.network.MarsPhoto
import java.lang.Exception

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.baseline_broken_image_24)
        }
    }
}
// this function need to be call for the data binding work correct, it is need to be called in some place
// with the auto generate code for the data binding work
// the problem was that the data-binding is not finding this function for set the value that needs
@BindingAdapter("caseData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsPhoto>? ) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

// todo how this parameters will be used?
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: MarsApiStatus) {
    when(status) {
        MarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        MarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.baseline_broken_image_24)
        }

        MarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}