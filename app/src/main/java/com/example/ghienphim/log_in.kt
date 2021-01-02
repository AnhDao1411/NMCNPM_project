package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.AppCompatButton

import com.example.ghienphim.R
import com.example.ghienphim.sql.DatabaseHelper
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_log_in.edit_tendangnhap
import kotlinx.android.synthetic.main.activity_register.*

class log_in : AppCompatActivity() {

    private val activity = this@log_in

    private lateinit var textInputEditUsername : EditText
    private lateinit var textInputEditPass : EditText

    private lateinit var appCompatButtonRegister: AppCompatButton
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        textInputEditUsername = edit_tendangnhap
        textInputEditPass = edit_matkhau_dn

        return_btn_dn.setOnClickListener{
            val intent= Intent(this, Option::class.java)
            startActivity(intent)
            finish()
        }

        // alertbox login failed
        btn_dn.setOnClickListener {
            if (textInputEditUsername.text.isBlank() || textInputEditPass.text.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập thông tin!!!", Toast.LENGTH_SHORT).show()
            } else {
                if (!validInput(it)) {
                    val errPopUp = AlertDialog.Builder(this)
                    errPopUp.setTitle(R.string.noti)
                    errPopUp.setMessage(R.string.wrongP)
                    errPopUp.setIcon(R.drawable.alert_img)
                    errPopUp.setNegativeButton("Huỷ", DialogInterface.OnClickListener() { dialog, id -> dialog.cancel() })
                    val alertDialog: AlertDialog = errPopUp.create()
                    alertDialog.show()
                }
                else
                {
                    val intent = Intent(this, HomeScreen::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
    private fun validInput(view: View):Boolean
    {
        //check Password's length is in range 8 - 20 letter
        if(textInputEditPass.text.length !in 8..20)
           return false
        return true
    }
}