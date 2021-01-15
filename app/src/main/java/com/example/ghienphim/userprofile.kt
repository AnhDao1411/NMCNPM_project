package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_userprofile.*

class userprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userprofile)
        profile_name.text = Cur.name.toString()


        btn_pyt.setOnClickListener{
            val intent = Intent(this, Favorite::class.java)
            startActivity(intent)
            finish()
        }

        btn_lichsu.setOnClickListener{
            val intent = Intent(this, history::class.java)
            startActivity(intent)
            finish()
        }

        btn_dmk.setOnClickListener{
            val intent = Intent(this, change_password::class.java)
            startActivity(intent)
            finish()
        }

        btn_dangxuat.setOnClickListener{
            val intent = Intent(this, Option::class.java)
            startActivity(intent)
            finish()
        }

        return_btn2.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}