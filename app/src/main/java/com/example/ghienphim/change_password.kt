package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_change_password.*

class change_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)


        // link to Profile by btn_xacnhan
        btn_xacnhan.setOnClickListener {
            val intent = Intent(this, userprofile::class.java)
            startActivity(intent)
            finish()
        }

        return_btn6.setOnClickListener {
            val intent = Intent(this, userprofile::class.java)
            startActivity(intent)
            finish()
        }


    }
}