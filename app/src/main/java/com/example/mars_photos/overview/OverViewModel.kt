package com.example.mars_photos.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mars_photos.network.MarsApi
import com.example.mars_photos.network.MarsPhoto
import kotlinx.coroutines.launch

class OverViewModel(): ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos: LiveData<List<MarsPhoto>> = _photos
    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = "Success Mars photos retrieved"

            } catch (e: Exception) {
                _status.value = "This have a ${e.message} problem, and is not possible" +
                        " to show the photos"
            }

        }
        Log.i("outside", "$status")
    }
}