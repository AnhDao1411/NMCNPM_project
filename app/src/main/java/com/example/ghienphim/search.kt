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

        return_btn4.setOnClickListener {
            val intent = Intent(this, change_password::class.java)
            startActivity(intent)
            finish()
        }
    }
}