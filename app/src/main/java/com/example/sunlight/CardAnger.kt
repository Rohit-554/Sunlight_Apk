package com.example.sunlight

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Sunlight.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_card_anger.*
import kotlinx.android.synthetic.main.activity_card_happy.*
import kotlinx.android.synthetic.main.activity_card_happy.music_card
import kotlinx.android.synthetic.main.activity_choose_mood.*

class CardAnger : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_anger)
        music_card.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://open.spotify.com/playlist/16HlqwCnp5XMaCE651sZzo")
            startActivity(openURL)
        }
        meditation.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://youtube.com/playlist?list=PLQiGxGHwiuD1kdxsWKFuhE0rITIXe-7yC")
            startActivity(openURL)
        }
        exercise_card.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://youtu.be/LNengFfaVGE")
            startActivity(openURL)
        }
        logout_cardanger.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

    }
}