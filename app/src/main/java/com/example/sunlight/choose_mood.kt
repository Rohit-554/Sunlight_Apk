package com.example.sunlight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Sunlight.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_choose_mood.*

class choose_mood : AppCompatActivity() {

    companion object {
        const val NAME = "NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_mood)
        card_happy.setOnClickListener { startActivity(Intent(this, CardHappy::class.java)) }
        card_sad.setOnClickListener { startActivity(Intent(this, CardSad::class.java)) }
        card_tired.setOnClickListener { startActivity(Intent(this, CardTired::class.java)) }
        card_anger.setOnClickListener { startActivity(Intent(this, CardAnger::class.java)) }
//        val intent = getIntent()
//        val name = intent.getStringExtra(NAME)
//        name_text.text = "HEY!!  " + name

//        FirebaseAuth.getInstance()
//        checkUser()

        logout_choosemood.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


    }

}