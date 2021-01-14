package com.example.ghienphim

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_userprofile.*



import com.example.ghienphim.databinding.ActivityUserprofileBinding
import androidx.databinding.DataBindingUtil
import com.example.ghienphim.model.CurrentUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.*

class userprofile : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityUserprofileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_userprofile)
        database = FirebaseDatabase.getInstance().getReference("user")
        binding.btnPyt.setOnClickListener{
            val intent = Intent(this, Favorite::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLichsu.setOnClickListener{
            val intent = Intent(this, history::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnDmk.setOnClickListener{
            val intent = Intent(this, change_password::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnDangxuat.setOnClickListener{
            val intent = Intent(this, Option::class.java)
            startActivity(intent)
            finish()
        }

        binding.returnBtn2.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }


    }

}




