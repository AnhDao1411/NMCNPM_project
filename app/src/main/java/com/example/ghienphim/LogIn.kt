package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

import com.example.ghienphim.sql.DatabaseHelper
import kotlinx.android.synthetic.main.activity_login.edit_tendangnhap


import kotlinx.android.synthetic.main.activity_login.*
import com.example.ghienphim.databinding.ActivityLoginBinding
import androidx.databinding.DataBindingUtil

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LogIn : AppCompatActivity() {

    private val activity = this@LogIn

    private lateinit var textInputEditUsername : EditText
    private lateinit var textInputEditPass : EditText

    private lateinit var appCompatButtonRegister: AppCompatButton
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        database = FirebaseDatabase.getInstance().getReference("user")
        textInputEditUsername = binding.editTendangnhap
        textInputEditPass = binding.editMatkhauDn

        initObjects()
        binding.returnBtnDn.setOnClickListener{
            val intent= Intent(this, Option::class.java)
            startActivity(intent)
            finish()
        }

        // alertbox login failed
        binding.btnDn.setOnClickListener {
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
                    verifyFromData(this)
//                    val intent = Intent(this, HomeScreen::class.java)
//                    startActivity(intent)
//                    finish()
                }
            }
        }
    }
    private fun verifyFromData(context: Context){
        if(databaseHelper!!.checkUser(username = textInputEditUsername.text.toString(), password = textInputEditPass.text.toString())){
            val intent = Intent(context, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
        else if(databaseHelper!!.checkWPassUser(username = textInputEditUsername.text.toString())){
            val labelErr = AlertDialog.Builder(context)
            labelErr.setTitle(R.string.noti)
            labelErr.setMessage(R.string.wrong_acc)
            labelErr.setIcon(R.drawable.alert_img)

            labelErr.setNegativeButton("Huỷ", DialogInterface.OnClickListener() { dialog, id -> dialog.cancel() })
            val alertDialog: AlertDialog = labelErr.create()
            alertDialog.show()
        }
        else {
            val labelErr = AlertDialog.Builder(context)
            labelErr.setTitle(R.string.noti)
            labelErr.setMessage(R.string.unavai_acc)
            labelErr.setIcon(R.drawable.alert_img)

            labelErr.setNegativeButton("Huỷ", DialogInterface.OnClickListener() {
                dialog, id -> dialog.cancel()
                val intent = Intent(context, Option::class.java)
                startActivity(intent)
                finish()})
            val alertDialog: AlertDialog = labelErr.create()
            alertDialog.show()
        }
    }
    private fun validInput(view: View):Boolean{
        //check Password's length is in range 8 - 20 letter
        if(textInputEditPass.text.length !in 8..20)
           return false
        return true
    }
    private fun initObjects(){
        databaseHelper = DatabaseHelper(activity)
    }
}