package com.example.tp_final.model

data class CountryItem (
    val name: Name,
    val flags: Flags,
    val capital: List<String>,
    val region: String,
    val population: Int
)