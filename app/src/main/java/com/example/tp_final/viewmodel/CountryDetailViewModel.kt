package com.example.tp_final.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp_final.model.CountryItemLong
import com.example.tp_final.model.CountryResponseLong
import com.example.tp_final.repository.CountryRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryDetailViewModel: ViewModel() {

    private val repository = CountryRepository()
    private val _country = MutableLiveData<List<CountryItemLong>>()
    val country : LiveData<List<CountryItemLong>> get() = _country

    fun getCountry(code : String) {
        repository.getCountry(code).enqueue(object : Callback<CountryResponseLong> {
            override fun onResponse(
                call: Call<CountryResponseLong>,
                response: Response<CountryResponseLong>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    _country.value = response.body()
                }
            }

            override fun onFailure(call: Call<CountryResponseLong>, t: Throwable) {
                Log.d("Error: ",t.message!!)
            }
        })
    }

}