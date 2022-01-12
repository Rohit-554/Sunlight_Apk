package com.example.sunlight

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Sunlight.R
import kotlinx.android.synthetic.main.activity_card_happy.*
import kotlinx.android.synthetic.main.activity_movie.*

class movietired : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movietired)
        hindi.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.scrolldroll.com/best-bollywood-comedy-movies/")
            startActivity(openURL)

        }
        english.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.rottentomatoes.com/top/bestofrt/top_100_comedy_movies/")
            startActivity(openURL)

        }

    }
}