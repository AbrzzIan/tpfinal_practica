package com.example.tp_final.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_final.databinding.FragmentHomeBinding
import com.example.tp_final.ui.adapter.CountryAdapter
import com.example.tp_final.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        homeViewModel.getCountries()
        homeViewModel.country.observe(viewLifecycleOwner) {countryList ->
            binding.recyclerView.adapter = CountryAdapter(countryList)
        }

        return binding.root
    }
}