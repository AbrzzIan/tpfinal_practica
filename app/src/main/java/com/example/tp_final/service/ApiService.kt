package com.example.tp_final.service

import com.example.tp_final.model.CountryResponseShort
import com.example.tp_final.model.CountryResponseLong
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("independent?status=true&fields=name,flags,cca3")
    fun getCountries(): Call<CountryResponseShort>

    @GET("alpha/{code}")
    fun getCountry(
        @Path("code") code : String
    ): Call<CountryResponseLong>

}