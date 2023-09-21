package com.example.earthquakes.overview

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakes.databinding.EarthquakeViewItemBinding
import com.example.earthquakes.entities.EarthquakeFeature
import com.example.earthquakes.entities.EarthquakeGeometry
import com.example.earthquakes.entities.EarthquakeProperties

class OverviewListAdapter(
    private val onClickListener: (EarthquakeFeature) -> Unit
) : RecyclerView.Adapter<OverviewListAdapter.EarthquakeItemViewHolder>() {


    var item1 = EarthquakeFeature(
    type = "",
    properties = EarthquakeProperties(
    mag = 1.3,
    place = "38 km SE of Tanana, Alaska",
    time = 1577923094766,
    updated = 1578698317093,
    tz = null,
    url = "https://earthquake.usgs.gov/earthquakes/eventpage/ak02021ksej",
    detail = "https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=ak02021ksej&format=geojson",
    felt = null,
    cdi = null,
    mmi = null,
    alert = null,
    status = "reviewed",
    tsunami = 0,
    sig = 26,
    net = "ak",
    code = "02021ksej",
    ids = ",ak02021ksej,",
    sources = ",ak,",
    types = ",origin,phase-data,",
    nst = null,
    dmin = null,
    rms = 0.81,
    gap = null,
    magType = "ml",
    type = "",
    title = "M 1.3 - 38 km SE of Tanana, Alaska"
    ),
    geometry = EarthquakeGeometry(
    type = "",
    coordinates = listOf()
    ),
    id = "")


    var data = listOf<EarthquakeFeature>(item1, item1, item1)


    class EarthquakeItemViewHolder private constructor(private val binding: EarthquakeViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(
            item: EarthquakeFeature,
            onClickListener: (EarthquakeFeature) -> Unit
        ) {
            binding.text1.text = item.properties.place
            //val getEarthquake = EarthquakeService.retrofitService.getEarthquakes()
            //val earthquakeItem = getEarthquake.await()
            Log.d("asdasd", "adapter!")
            //binding.text2.text = item.properties.title
            itemView.setOnClickListener { onClickListener(item) }
        }

        companion object {
            fun from(parent: ViewGroup): EarthquakeItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EarthquakeViewItemBinding.inflate(layoutInflater, parent, false)
                return EarthquakeItemViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeItemViewHolder {
        return EarthquakeItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        Log.d("asdasd", "adaptercc: ${data.size}")
        return data.size
    }

    override fun onBindViewHolder(holder: EarthquakeItemViewHolder, position: Int) {
        val item = data[position]
        Log.d("asdasd", "viewgolder111: ${item.properties.place}")
        holder.bind(item, onClickListener)
    }
}