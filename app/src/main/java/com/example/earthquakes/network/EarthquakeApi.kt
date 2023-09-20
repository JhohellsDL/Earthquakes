package com.example.earthquakes.network

import com.example.earthquakes.entities.Earthquake
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

private const val REQUEST_EARTHQUAKE_LIST = "query?format=geojson&starttime=2020-01-01&endtime=2020-01-02"

interface EarthquakeApi {

    @GET(REQUEST_EARTHQUAKE_LIST)
    fun getEarthquakes(): Deferred<Earthquake>

}