package com.example.earthquakes.entities

data class EarthquakeFeature(
    val type: String,
    val properties: EarthquakeProperties,
    val geometry: EarthquakeGeometry,
    val id: String
)
