package com.example.mars_photos.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mars_photos.databinding.GridViewItemBinding
import com.example.mars_photos.network.MarsPhoto

class PhotoGridAdapter: ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotosViewHolder>(DiffCallback) {
    class MarsPhotosViewHolder(private val binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(marsPhoto: MarsPhoto) {
            marsPhoto.also { binding.photos }
            binding.executePendingBindings()
        }
    }


    companion object DiffCallback: DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }

        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotosViewHolder {
        return MarsPhotosViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsPhotosViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }


}