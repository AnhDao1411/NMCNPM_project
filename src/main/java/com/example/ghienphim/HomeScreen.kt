package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.PopupMenu
import com.example.ghienphim.model.readFireStore
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_userprofile.*

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

        btn_quocgia.setOnClickListener{
            val popup=PopupMenu(this,btn_quocgia)
            popup.inflate(R.menu.show_quoc_gia)
            popup.setOnMenuItemClickListener{
                Toast.makeText(this, "Item : "+it.title, Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }

        btn_nam.setOnClickListener{
            val popup=PopupMenu(this,btn_nam)
            popup.inflate(R.menu.show_nam)
            popup.setOnMenuItemClickListener{
                Toast.makeText(this, "Item : "+it.title, Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }

        profile_btn.setOnClickListener{
            val intent= Intent(this, userprofile::class.java)
            startActivity(intent)
            finish()
        }


        // NEW FEATURE
        search_btn.setOnClickListener{
            val intent= Intent(this, search::class.java)
            readFireStore()
            startActivity(intent)
            finish()
        }


        home_film1.setOnClickListener{
            val intent= Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        home_film2.setOnClickListener{
            val intent= Intent(this, description_12::class.java)
            startActivity(intent)
            finish()
        }
        home_film3.setOnClickListener{
            val intent= Intent(this, description_vd::class.java)
            startActivity(intent)
            finish()
        }
        home_film4.setOnClickListener{
            val intent= Intent(this, Description2::class.java)
            startActivity(intent)
            finish()
        }
        home_film5.setOnClickListener{
            val intent= Intent(this, description_12::class.java)
            startActivity(intent)
            finish()
        }
        home_film6.setOnClickListener{
            val intent= Intent(this, description_vd::class.java)
            startActivity(intent)
            finish()
        }
        home_film7.setOnClickListener{
            val intent= Intent(this, Description2::class.java)
            startActivity(intent)
            finish()
        }

        home_film8.setOnClickListener{
            val intent= Intent(this, description_vd::class.java)
            startActivity(intent)
            finish()
        }
        home_film9.setOnClickListener{
            val intent= Intent(this, description_12::class.java)
            startActivity(intent)
            finish()
        }
        home_film10.setOnClickListener{
            val intent= Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }

        home_film11.setOnClickListener{
            val intent= Intent(this, description_vd::class.java)
            startActivity(intent)
            finish()
        }
        home_film12.setOnClickListener{
            val intent= Intent(this, description_12::class.java)
            startActivity(intent)
            finish()
        }


    }
}

