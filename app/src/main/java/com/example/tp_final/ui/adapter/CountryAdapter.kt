package com.example.tp_final.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tp_final.databinding.ItemListAdapterBinding
import com.example.tp_final.model.CountryItemShort
import com.example.tp_final.ui.HomeFragmentDirections

class CountryAdapter(private val countryList: List<CountryItemShort>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: ItemListAdapterBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemListAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country  = countryList[position]

        holder.binding.tvName.text = country.name.common
        Glide
            .with(holder.binding.root.context)
            .load(country.flags.png)
            .into(holder.binding.ivFlag)

        holder.binding.rowLayoutIdFrag.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToCountryDetailFragment(country.cca3)
            holder.itemView.findNavController().navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return countryList.size
    }

}