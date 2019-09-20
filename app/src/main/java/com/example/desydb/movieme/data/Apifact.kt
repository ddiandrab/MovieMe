package com.example.desydb.movieme.data

import android.graphics.Movie
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "3b0d8dc41dd4122b770164942600f4ad"

//https://api.themoviedb.org/3/movie/popular?api_key=3b0d8dc41dd4122b770164942600f4ad

object Apifact {

    fun retrofit() : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

