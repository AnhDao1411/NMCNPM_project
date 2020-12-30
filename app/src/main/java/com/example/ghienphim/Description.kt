package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_description.*


class Description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)


        return_btn5.setOnClickListener{
            val intent= Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        btn_cmt.setOnClickListener {
            val intent = Intent(this, ChatBox::class.java)
            startActivity(intent)
            finish()
        }
    }




}

