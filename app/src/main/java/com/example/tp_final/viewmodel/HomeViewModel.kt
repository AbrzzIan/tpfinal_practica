package com.example.tp_final.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp_final.model.CountryItemShort
import com.example.tp_final.model.CountryResponseShort
import com.example.tp_final.repository.CountryRepository
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private val repository = CountryRepository()

    private val _countries = MutableLiveData<List<CountryItemShort>>()
    val country : LiveData<List<CountryItemShort>> get() = _countries


    fun getCountries() {
        repository.getCountries().enqueue(object : Callback<CountryResponseShort> {
            override fun onResponse(
                call: Call<CountryResponseShort>,
                response: Response<CountryResponseShort>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    _countries.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<CountryResponseShort>, t: Throwable) {
                Log.d("Error: ", t.message!!)
            }
        })
    }
}