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
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private val activity = this@Register

    private lateinit var textInputEditEmail : EditText
    private lateinit var textInputEditUsername : EditText
    private lateinit var textInputEditPass : EditText
    private lateinit var textInputEditAge : EditText
    private lateinit var textInputEditConPass : EditText

    private lateinit var appCompatButtonRegister: AppCompatButton
    private lateinit var databaseHelper: DatabaseHelper

    //    private fun avaiInput(view: View):Boolean
//    {
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        textInputEditAge = edit_tuoi
        textInputEditConPass = edit_xacnhanmatkhau
        textInputEditPass = edit_matkhau
        textInputEditEmail = edit_email
        textInputEditUsername = edit_tendangnhap

        return_btn.setOnClickListener{
            val intent= Intent(this, Option::class.java)
            startActivity(intent)
            finish()
        }

        btn_dangky.setOnClickListener {
            if (textInputEditEmail.text.isBlank() || textInputEditUsername.text.isBlank()
                    || textInputEditPass.text.isBlank() || textInputEditConPass.text.isBlank()
                    || textInputEditAge.text.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập thông tin!!!", Toast.LENGTH_SHORT).show()
            } else {
//            Toast.makeText(this, textInputEditEmail.text, Toast.LENGTH_LONG).show()
                val opt = validInput(it)
                if (opt == 1) {
                    val labelErr = AlertDialog.Builder(this)
                    labelErr.setTitle(R.string.noti)
                    labelErr.setMessage(R.string.wrongP)
                    labelErr.setIcon(R.drawable.alert_img)

                    labelErr.setNegativeButton("Huỷ", DialogInterface.OnClickListener() { dialog, id -> dialog.cancel() })
                    val alertDialog: AlertDialog = labelErr.create()
                    alertDialog.show()
                } else if (opt == 2) {
                    val labelErr = AlertDialog.Builder(this)
                    labelErr.setTitle(R.string.noti)
                    labelErr.setMessage(R.string.wrongA)
                    labelErr.setIcon(R.drawable.alert_img)

                    labelErr.setNegativeButton("Huỷ", DialogInterface.OnClickListener() { dialog, id -> dialog.cancel() })
                    val alertDialog: AlertDialog = labelErr.create()
                    alertDialog.show()
                } else if (opt == 3) {
                    val labelErr = AlertDialog.Builder(this)
                    labelErr.setTitle(R.string.noti)
                    labelErr.setMessage(R.string.invalidE)
                    labelErr.setIcon(R.drawable.alert_img)

                    labelErr.setNegativeButton("Huỷ", DialogInterface.OnClickListener() { dialog, id -> dialog.cancel() })
                    val alertDialog: AlertDialog = labelErr.create()
                    alertDialog.show()
                } else {
                    val intent = Intent(this, HomeScreen::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun validInput(view: View):Int
    {
        val edit_A = textInputEditAge.text.toString().toInt()
        var opt :Int
        //check Password's length is in range 8 - 20 letter
        if(textInputEditPass.text.length !in 8..20)
            opt = 1

        //Check valid age
        else if(edit_A < 0 || edit_A > 100)
            opt = 2

        //check valid email
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(textInputEditEmail.text).matches())
            opt = 3
        else
            opt = 0
        return opt
    }

}