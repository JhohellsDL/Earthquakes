package com.example.earthquakes.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

private const val REQUEST_EARTHQUAKE_LIST = "query?format=geojson&starttime=2020-01-01&endtime=2020-01-02"

interface EarthquakeApi {

    @GET(REQUEST_EARTHQUAKE_LIST)
    fun getEarthquakes(): Deferred<Earthquake>

}