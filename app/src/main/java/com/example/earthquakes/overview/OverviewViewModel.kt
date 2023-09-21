package com.example.earthquakes.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.earthquakes.entities.EarthquakeFeature
import com.example.earthquakes.network.EarthquakeService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _listEarthquakeFeatures = MutableLiveData<List<EarthquakeFeature>>()
    val listEarthquakeFeatures: LiveData<List<EarthquakeFeature>>
        get() = _listEarthquakeFeatures

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getEarthquakeFeatures()
    }

    private fun getEarthquakeFeatures() {
        coroutineScope.launch {
            val getFeaturesDeferred = EarthquakeService.retrofitService.getEarthquakes()
            try {
                val result = getFeaturesDeferred.await()
                _status.value = "Llamada exitosa : ${result.features.size}"
                _listEarthquakeFeatures.value = result.features
                Log.d("asdasd", "viewmodel - ${listEarthquakeFeatures.value!!.size}")
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