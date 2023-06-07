package com.example.tp_final.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_final.databinding.ItemListAdapterBinding
import com.example.tp_final.model.CountryItemShort

class CountryAdapter(private val countryList: List<CountryItemShort>) : RecyclerView.Adapter<CountryAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(val binding: ItemListAdapterBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemListAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val country  = countryList[position]

        holder.binding.tvName.text = country.name.common
        holder.binding.ivFlag.setImageURI(country.flags.png.toUri())
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

}