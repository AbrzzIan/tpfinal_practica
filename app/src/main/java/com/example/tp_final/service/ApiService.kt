package com.example.tp_final.service

import com.example.tp_final.model.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all?fields=name,flags")
    fun getCharacters(): Call<CountryResponse>
}