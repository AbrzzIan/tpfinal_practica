package com.example.tp_final.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp_final.model.CountryItemShort
import com.example.tp_final.model.CountryResponse
import com.example.tp_final.repository.CountryRepository
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private val repository = CountryRepository()

    private val _countries = MutableLiveData<List<CountryItemShort>>()
    val country : LiveData<List<CountryItemShort>> get() = _countries


    fun getCountries() {
        repository.getCountries().enqueue(object : Callback<CountryResponse> {
            override fun onResponse(
                call: Call<CountryResponse>,
                response: Response<CountryResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    _countries.value = response.body()!!
                }
            }
            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}