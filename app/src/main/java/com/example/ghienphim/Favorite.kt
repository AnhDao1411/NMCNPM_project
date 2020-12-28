package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_favorite.*

class Favorite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        return_btn2.setOnClickListener {
            val intent = Intent(this, history::class.java)
            startActivity(intent)
            finish()
        }
    }


    

}