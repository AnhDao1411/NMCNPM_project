package com.example.ghienphim

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ghienphim.model.FilmAdapter
import com.example.ghienphim.model.FilmsModel
import com.example.ghienphim.sql.DatabaseHelper
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.activity_search.*


class Description : AppCompatActivity() {
    private val activity = this@Description
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var name:String
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var collectionReference: CollectionReference
    var filmAdapter: FilmAdapter ?=null

    private fun initObjects(){
        databaseHelper = DatabaseHelper(activity)
    }
    //private lateinit var film_name : TextView
    @SuppressLint("UseValueOf")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        initObjects()
        val intent = getIntent()
        name = intent.getStringExtra("key").toString()
        collectionReference = db.collection("Films")
        //setUpRecyclerview()


//        val mList = ArrayList<FilmsModel>()
//        var film  = collectionReference.get()
//                .addOnSuccessListener(OnSuccessListener<QuerySnapshot> { queryDocumentSnapshots ->
//            if (!queryDocumentSnapshots.isEmpty) {
//                for (journals in queryDocumentSnapshots) {
//                    val jobPost: FilmsModel = journals.toObject(FilmsModel::class.java)
//                    mList.add(jobPost)
//                }
//            }
//        })
//                .addOnFailureListener(OnFailureListener { })


        return_btn5.setOnClickListener{
            val intent= Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
        btn_cmt.setOnClickListener {
            val intent = Intent(this, ChatBox::class.java)
            startActivity(intent)
            finish()
        }
        home_dis.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        btn_heart.setOnClickListener{
                if (databaseHelper.addFilm(name.toString()) != -1L)
                    Toast.makeText(this, "thanh cong", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "that bai", Toast.LENGTH_SHORT).show()

                databaseHelper.getAllFilm()
            }


    }
//    fun setUpRecyclerview(){
////        val query: Query = collectionReference.whereEqualTo(name,ref)
//        val query: Query = collectionReference.whereEqualTo("Name",name)
//        val firestoreRecyclerOptions: FirestoreRecyclerOptions<FilmsModel> = FirestoreRecyclerOptions.Builder<FilmsModel>()
//                .setQuery(query, FilmsModel::class.java).build()
        //filmAdapter = FilmAdapter(firestoreRecyclerOptions)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = filmAdapter


}

