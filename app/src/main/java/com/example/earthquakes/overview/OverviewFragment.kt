package com.example.earthquakes.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.earthquakes.R
import com.example.earthquakes.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOverviewBinding.inflate(inflater)
        val viewModel = ViewModelProvider(this)[OverviewViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = OverviewListAdapter(
            onClickListener = {
                Log.d("asdasd", "earthquake: ${it.properties.place}")
            }
        )

        binding.earthquakeRecyclerView.adapter = adapter

        viewModel.listEarthquakeFeatures.observe(viewLifecycleOwner){
            Log.d("asdasd", "viewmodelasdfasd: ${it[0].properties}")
            adapter.data = it!!
        }

        return binding.root
    }

}