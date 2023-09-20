package com.example.earthquakes.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.earthquakes.network.Earthquake
import com.example.earthquakes.network.EarthquakeApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getMarsRealEstateProperties()
    }

    private fun getMarsRealEstateProperties() {
        coroutineScope.launch {

            val getPropertiesDeferred = EarthquakeApiService.retrofitService.getEarthquakes()

            try {
                val result = getPropertiesDeferred.await()
                _status.value = "Llamada exitosa : $result"
            } catch (e: Exception) {
                _status.value = "Llamada fallida : " + e.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}