package com.example.ghienphim.model

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Film (val name : String,
            val des : String,
            val genre: String,
            val rating: Float,
            val trailer: String?,
            val age: String,
            val cast: String){
}

fun readFireStore(){
    val db = Firebase.firestore
    db.collection("Films")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                // using document.data to create a Film object.
                Log.d(TAG, "${document.id} => ${document.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.d(TAG, "Error getting documents: ", exception)
        }
}