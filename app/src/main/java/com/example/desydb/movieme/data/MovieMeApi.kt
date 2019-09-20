package com.example.desydb.movieme.data

import com.example.desydb.movieme.data.response.GenreResponse
import com.example.desydb.movieme.data.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

const val API_DB = "3b0d8dc41dd4122b770164942600f4ad"

interface MovieMeApi {

    @GET("movie/top_rated?api_key="+API_DB)
    fun getTopRated(): Call<MovieResponse>

    @GET("movie/upcoming?api_key="+API_DB)
    fun getUpcoming(): Call<MovieResponse>

    @GET("movie/now_playing?api_key="+API_DB)
    fun getNowPlaying(): Call<MovieResponse>

    @GET("movie/popular?api_key="+API_DB)
    fun getPopularMovie(): Call<MovieResponse>

    @GET("genre/movie/list?api_key"+API_DB)
    fun getMoviebyId() : Call<GenreResponse>
}