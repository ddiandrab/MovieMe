package com.example.desydb.movieme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.desydb.movieme.R
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desydb.movieme.data.Apifact
import com.example.desydb.movieme.data.MovieMeApi
import com.example.desydb.movieme.data.response.GenreResponse
import com.example.desydb.movieme.data.response.GenreResult
import com.example.desydb.movieme.data.response.MovieResponse
import com.example.desydb.movieme.data.response.MovieResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var mView: RecyclerView
    private lateinit var mAdapter: MovieAdapter
    private lateinit var gmlayoutManager : GridLayoutManager
    private lateinit var listResult: List<MovieResult>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mView = findViewById(R.id.movieView) as RecyclerView

        val api = Apifact.retrofit().create(MovieMeApi::class.java)
        var moviee : List<MovieResult>
        var genre : List<GenreResult>
        api.getPopularMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
               showData(response.body()!!.results)
                d("Movie", "onResponse: ${response.body()!!.results[0].poster_path}")
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
        })
    }

    private fun showData(movie: List<MovieResult>){
        mView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = MovieAdapter(this@MainActivity, movie)
        }
    }
}