package com.example.tp_final.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.tp_final.databinding.FragmentCountryinfoBinding
import com.example.tp_final.viewmodel.CountryDetailViewModel

class CountryDetailFragment: Fragment() {

    private val countryDetailViewModel by viewModels<CountryDetailViewModel>()
    private lateinit var binding: FragmentCountryinfoBinding
    private val args by navArgs<CountryDetailFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCountryinfoBinding.inflate(inflater,container,false)
        countryDetailViewModel.getCountry(args.countryId)
        countryDetailViewModel.country.observe(viewLifecycleOwner) {
            val country = this.countryDetailViewModel.country.value!![0]
            binding.tvName.text = country.name.common
            binding.tvCapital.text = country.capital[0]
            binding.tvContinent.text = country.region
            binding.tvPopulation.text = country.population.toString()

            Glide
            .with(this.requireContext())
            .load(country.flags.png)
            .into(binding.imageView)
        }

        return binding.root
    }

}