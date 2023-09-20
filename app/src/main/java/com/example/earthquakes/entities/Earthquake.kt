package com.example.earthquakes.entities

import com.example.earthquakes.entities.EarthquakeMetadata

data class Earthquake (
    val type: String = "",
    val metadata: EarthquakeMetadata,
    val features: List<EarthquakeFeature>
)