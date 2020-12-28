package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_favorite.*

class Favorite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)


        // link to profile by return_btn2

        //link to homescreen
        home_fav.setOnClickListener{
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        // link to description
        fav_1.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        fav_2.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        fav_3.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        fav_4.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        fav_5.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        fav_6.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        //press star to add database
    }


    

}