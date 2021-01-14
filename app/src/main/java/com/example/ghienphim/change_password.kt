package com.example.ghienphim

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ghienphim.databinding.ActivityChangePasswordBinding
import com.google.firebase.database.*


class change_password : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    private lateinit var binding: ActivityChangePasswordBinding
    private lateinit var textInputEditCurpass : EditText
    private lateinit var textInputEditNewpass : EditText
    private lateinit var textInputEditConfirm : EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_password)
        database = FirebaseDatabase.getInstance().getReference("user")

        textInputEditCurpass = binding.curEdit
        textInputEditCurpass = binding.newEdit
        textInputEditConfirm = binding.confirmEdit
        // link to Profile by btn_xacnhan
        binding.btnXacnhan.setOnClickListener {
            val intent = Intent(this, userprofile::class.java)
            startActivity(intent)
            finish()
        }

        binding.returnChangeP.setOnClickListener {
            val intent = Intent(this, userprofile::class.java)
            startActivity(intent)
            finish()
        }



    }


}