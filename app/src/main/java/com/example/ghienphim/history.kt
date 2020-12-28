package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ghienphim.history
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_history.*

class history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        return_btn3.setOnClickListener {
            val intent = Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }
    }
}