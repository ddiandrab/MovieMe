package com.example.desydb.movieme.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.example.desydb.movieme.R
import com.example.desydb.movieme.data.response.GenreResult
import com.example.desydb.movieme.data.response.MovieResult
import com.squareup.picasso.Picasso

class MovieAdapter(var context: Context, var results: List<MovieResult>) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.list_movie, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val judul = results[position].title
        val gambar = results[position].poster_path
        val gbr_back = results[position].backdrop_path
        val rating = results[position].vote_average
        val overview = results[position].overview
        val release = results[position].release_date


        Picasso.get()
            .load("http://image.tmdb.org/t/p/w185" + gambar)
            .into(holder.Poster)

        holder.Poster.setOnClickListener{
            val intent = Intent(context, MovieDetail::class.java)
            intent.putExtra("Judul", judul)
            intent.putExtra("Gambar", gambar)
            intent.putExtra("Back", gbr_back)
            intent.putExtra("Rating", rating.toString())
            intent.putExtra("Overview", overview)
            intent.putExtra("Release", release)
            context.startActivity(intent)

        }

    }

//    fun getGenre(genreId: List<Int>) {
//        var movieGenre : MutableList<String> = mutableListOf<String>()
//        for(genId: Int in genreId){
//            for (genre: GenreResult in allGenre){
//                if(genre.id == genId){
//                    movieGenre.add(genre.name)
//                    break
//                }
//            }
//        }
//        return TextUtils.split(movieGenre, ", ");
//    }

    //image.tmdb.org/t/p/w185
    override fun getItemCount(): Int {
        return results.size
    }

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Poster: ImageView

        init {
            Poster = itemView.findViewById<View>(R.id.poster) as ImageView
        }
    }
}
