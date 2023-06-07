package com.example.tp_final.repository

import com.example.tp_final.model.CountryResponse
import com.example.tp_final.model.CountryResponseLong
import com.example.tp_final.service.ApiService
import com.example.tp_final.service.RetrofitService
import retrofit2.Call

class CountryRepository {

    private val retrofit: ApiService = RetrofitService.getInstance()

    fun getCountries() : Call<CountryResponse> {
        return retrofit.getCountries()
    }


    fun getCountry(code : String): Call<CountryResponseLong> {
        return retrofit.getCountry(code)
    }
}