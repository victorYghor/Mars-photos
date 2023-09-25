package com.example.mars_photos.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mars_photos.network.MarsApi
import com.example.mars_photos.network.MarsPhoto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class OverviewViewModel(): ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _photos = MutableLiveData<MarsPhoto>()
    val photos: LiveData<MarsPhoto> = _photos
    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getPhotos()
                // por algum motivo o codigo aqui não é executado
                Log.i("reach", "try to catch $listResult")
                Log.i("before", "before this is the value of _status ${_status.value}")
                Log.i("before", " before this is the value of status ${status.value}")
                _status.value = "Success: ${listResult.size} Mars photos retrieved"
                Log.i("after", "after this is the value of _status ${_status.value}")
                Log.i("after", " after this is the value of status ${status.value}")
            } catch (e: Exception) {
                _status.value = "This have a ${e.message} problem, and is not possible" +
                        " to show the photos"
            }

        }
        Log.i("outside", "$status")
    }
}