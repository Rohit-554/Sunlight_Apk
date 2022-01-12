package com.example.sunlight

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Sunlight.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_card_happy.*
import kotlinx.android.synthetic.main.activity_card_happy.movie_card
import kotlinx.android.synthetic.main.activity_card_happy.music_card
import kotlinx.android.synthetic.main.activity_card_sad.*
import kotlinx.android.synthetic.main.activity_choose_mood.*

class CardSad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_sad)

        music_card.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://open.spotify.com/playlist/3FodghaOx56cNmeQeFw5Ya")
            startActivity(openURL)
        }
        movie_card.setOnClickListener{ startActivity(Intent(this, moviesad::class.java))}
        card_memoir.setOnClickListener{ startActivity(Intent(this, Memoir::class.java))}

        logout_cardsad.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }


}