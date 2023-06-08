package com.example.dummyapplication.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val Base_URL = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): Retrofit
    {
        return Retrofit.Builder().
        baseUrl(Base_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }
}