package com.example.ghienphim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        btn_show_popup.setOnClickListener{
            val popup=PopupMenu(this,btn_show_popup)
            popup.inflate(R.menu.list_popup_window_item)
            popup.setOnMenuItemClickListener{
                Toast.makeText(this, "Item : "+it.title, Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }
    }
}

