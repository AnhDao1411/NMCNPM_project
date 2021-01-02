package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_log_in.*
import android.app.AlertDialog
import android.widget.Toast

class log_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

//        btn_dn.setOnClickListener{
//            val intent= Intent(this, HomeScreen::class.java)
//            startActivity(intent)
//            finish()
//        }

        // alertbox login failed
        btn_dn.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.noti)
            builder.setMessage(R.string.noti_info)
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setNegativeButton("Huỷ"){_,_ ->
                Toast.makeText(applicationContext,
                        "Cancel", Toast.LENGTH_SHORT).show()}
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}