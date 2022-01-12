package com.example.sunlight

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Sunlight.R
import kotlinx.android.synthetic.main.activity_card_happy.*
import kotlinx.android.synthetic.main.activity_movie.*

class moviesad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moviesad)
        hindi.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.idiva.com/entertainment/bollywood/10-sad-bollywood-movies-that-made-us-weep-like-babies/18007144")
            startActivity(openURL)

        }
        english.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.marieclaire.com/culture/news/a26452/best-sad-movies/")
            startActivity(openURL)

        }

    }
}