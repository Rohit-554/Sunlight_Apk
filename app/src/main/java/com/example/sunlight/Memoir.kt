package com.example.sunlight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.Sunlight.R
import kotlinx.android.synthetic.main.activity_memoir.*

class Memoir : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memoir)
        myEditText.setOnTouchListener { view, event ->
            view.parent.requestDisallowInterceptTouchEvent(true)
            if ((event.action and MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                view.parent.requestDisallowInterceptTouchEvent(false)
            }
            return@setOnTouchListener false
        }
        btn_save.setOnClickListener {
            val edit_view= myEditText.text.toString()
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,edit_view )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}