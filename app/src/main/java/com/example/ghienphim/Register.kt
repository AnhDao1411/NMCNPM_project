package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        return_btn.setOnClickListener{
            val intent= Intent(this, Option::class.java)
            startActivity(intent)
            finish()
        }

        btn_dangky.setOnClickListener{
            val intent= Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}