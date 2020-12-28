package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_home_screen.return_btn
import kotlinx.android.synthetic.main.activity_register.*

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        btn_theloai.setOnClickListener{
            val popup=PopupMenu(this,btn_theloai)
            popup.inflate(R.menu.list_popup_window_item)
            popup.setOnMenuItemClickListener{
                Toast.makeText(this, "Item : "+it.title, Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }


        btn_quocgia.setOnClickListener {
            val intent = Intent(this, Favorite::class.java)
            startActivity(intent)
            finish()
        }
        return_btn.setOnClickListener{
            val intent= Intent(this, Option::class.java)
            startActivity(intent)
            finish()
        }


    }
}

