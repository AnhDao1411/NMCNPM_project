package com.example.ghienphim

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ghienphim.sql.DatabaseHelper
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_description.*


class Description : AppCompatActivity() {
    private val activity = this@Description
    private lateinit var databaseHelper: DatabaseHelper
    private fun initObjects(){
        databaseHelper = DatabaseHelper(activity)
    }
    //private lateinit var film_name : TextView
    @SuppressLint("UseValueOf")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val intent = getIntent()
        filmName.text = intent.getStringExtra("name").toString()
        description.text = intent.getStringExtra("Description").toString()
        film_inf.text = intent.getStringExtra("Casts").toString()
        val imgLink = intent.getStringExtra("ImageLink").toString()
//        Picasso.get().load(imgLink).into(imageView3)
        rate.text = intent.getStringExtra("Rating").toString()
        initObjects()
        return_btn5.setOnClickListener{
            if(Cur.opt==1) {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this, main_an::class.java)
                startActivity(intent)
                finish()
            }
        }

        btn_cmt.setOnClickListener {
            val intent = Intent(this, ChatBox::class.java)
            startActivity(intent)
            finish()
        }
        btn_heart.setOnClickListener{
            if (databaseHelper.addFilm(filmName.text.toString()) != -1L)
                Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Thất bại", Toast.LENGTH_SHORT).show()
        }
        home_dis.setOnClickListener {
            if(Cur.opt==1) {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this, main_an::class.java)
                startActivity(intent)
                finish()
            }
        }
    }




}

