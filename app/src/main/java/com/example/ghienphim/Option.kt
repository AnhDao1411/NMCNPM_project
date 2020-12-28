package com.example.ghienphim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_option.*
import android.content.Intent

class Option : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)
        btn_dangky.setOnClickListener{
            val intent=Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }

        // press an danh to go HomeScreen
        btn_andanh.setOnClickListener{
            val intent=Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

    }
}