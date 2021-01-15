package com.example.ghienphim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ghienphim.model.FilmAdapter
import com.example.ghienphim.model.FilmsModel
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_search.*

class search : AppCompatActivity() {
    private val db:FirebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var collectionReference:CollectionReference
    var filmAdapter: FilmAdapter ?=null
//    private lateinit var ref:DocumentReference
    private lateinit var name:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val intent = getIntent()
        name = intent.getStringExtra("key").toString()
        collectionReference = db.collection("Films")

        setUpRecyclerview()
        //link to HomeScreen
        return_btn4.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

//        search_1.setOnClickListener {
//            val intent = Intent(this, Description::class.java)
//            startActivity(intent)
//            finish()
//        }

        home_search.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun setUpRecyclerview(){
//        val query: Query = collectionReference.whereEqualTo(name,ref)
        val query: Query = collectionReference.whereEqualTo("Name",name)
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<FilmsModel> = FirestoreRecyclerOptions.Builder<FilmsModel>()
            .setQuery(query, FilmsModel::class.java).build()
        filmAdapter = FilmAdapter(firestoreRecyclerOptions)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = filmAdapter
    }

    override fun onStart()
    {
        super.onStart()
        filmAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        filmAdapter!!.stopListening()
    }
}