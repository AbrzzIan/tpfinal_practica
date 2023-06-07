package com.example.tp_final.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        Glide
            .with(holder.binding.root.context)
            .load(country.flags.png)
            .into(holder.binding.ivFlag)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

}