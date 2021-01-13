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
            val intent=Intent(this, main_an::class.java)
            startActivity(intent)
            finish()
        }

        btn_dangnhap.setOnClickListener{
            val intent=Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()
        }

    }
}