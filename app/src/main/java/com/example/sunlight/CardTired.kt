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
import kotlinx.android.synthetic.main.activity_card_tired.*
import kotlinx.android.synthetic.main.activity_choose_mood.*

class CardTired : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_tired)
        music_card.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://open.spotify.com/playlist/0fjFCCGiRYPcDLHrfqthcT")
            startActivity(openURL)
        }
        movie_card.setOnClickListener { startActivity(Intent(this, movietired::class.java)) }
        jokes.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.laughfactory.com/jokes/latest-jokes")
            startActivity(openURL)
        }
        logout_cardtired.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}