package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_description_bg.*

class description_vd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_vd)

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

        home_dis.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}