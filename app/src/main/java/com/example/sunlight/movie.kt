package com.example.sunlight

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Sunlight.R
import kotlinx.android.synthetic.main.activity_card_happy.*
import kotlinx.android.synthetic.main.activity_movie.*

class movie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        hindi.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.imdb.com/india/top-rated-indian-movies/")
                startActivity(openURL)

        }
        english.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.rottentomatoes.com/top/bestofrt/top_100_action__adventure_movies/")
            startActivity(openURL)

        }

    }
}