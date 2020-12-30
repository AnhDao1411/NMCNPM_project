package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_log_in.*

class log_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        btn_dn.setOnClickListener{
            val intent= Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}