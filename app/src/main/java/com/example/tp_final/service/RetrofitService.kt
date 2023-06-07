package com.example.tp_final.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {
    @Volatile
    private var INSTANCE: ApiService? = null


    fun getInstance(): ApiService {
        synchronized(this) {
            return INSTANCE ?: buildService().also {
                INSTANCE = it
            }
        }
    }
    private fun buildService(): ApiService {
        val url = "https://restcountries.com/v3.1/"


        val httpClient: OkHttpClient.Builder =
            OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)



        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        return retrofit.create(ApiService::class.java)
    }


}