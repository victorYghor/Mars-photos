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
    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getPhotos()
                // por algum motivo o codigo aqui não é executado
                Log.i("reach", "try to catch $listResult")
                Log.i("reach", "verify if the code reach this point")
                Log.i("reach", "verify if the code reach this point")
                Log.i("before", "this is the value of _status ${_status.value}")
                Log.i("reach", "this is the value of _status ${_status.value}")
                _status.value = "Success: ${listResult.size} Mars photos retrieved"
                Log.i("reach", _status.value.toString())
                Log.i("reach", status.value.toString())
                Log.i("reach", "verify if the code reach this point after")
            } catch (e: Exception) {
                _status.value = "This have a ${e.message} problem, and is not possible" +
                        " to show the photos"
            }

        }
    }
}