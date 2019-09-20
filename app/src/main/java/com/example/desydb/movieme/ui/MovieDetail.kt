package com.example.desydb.movieme.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.desydb.movieme.R
import com.squareup.picasso.Picasso

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var intent = intent
        val judul = intent.getStringExtra("Judul")
        val gambar = intent.getStringExtra("Gambar")
        val back = intent.getStringExtra("Back")
        val rate = intent.getStringExtra("Rating")
        val overview = intent.getStringExtra("Overview")
        val date = intent.getStringExtra("Release")


        val gmbr = findViewById<ImageView>(R.id.detail_gambar)
        val jdl = findViewById<TextView>(R.id.detail_judul)
        val rating = findViewById<TextView>(R.id.detail_rating)
        val overvw = findViewById<TextView>(R.id.detail_overview)
        val datee = findViewById<TextView>(R.id.detail_date)

        Picasso.get()
            .load("http://image.tmdb.org/t/p/w185" + back)
            .into(gmbr)
        jdl.text = judul
        rating.text = rate.toString()
        overvw.text = overview
        datee.text = date
    }
}