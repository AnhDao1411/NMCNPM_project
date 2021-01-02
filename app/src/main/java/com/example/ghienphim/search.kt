package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_search.*

class search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        //link to HomeScreen
        return_btn4.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        search_1.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        search_2.setOnClickListener {
            val intent = Intent(this, description_12::class.java)
            startActivity(intent)
            finish()
        }

        search_3.setOnClickListener {
            val intent = Intent(this, description_vd::class.java)
            startActivity(intent)
            finish()
        }

        search_4.setOnClickListener {
            val intent = Intent(this, Description2::class.java)
            startActivity(intent)
            finish()
        }

        search_5.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        search_6.setOnClickListener {
            val intent = Intent(this, description_12::class.java)
            startActivity(intent)
            finish()
        }

        home_search.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }


    }
}