package com.stockbuddy.domain.users

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.firestore

val db = Firebase.firestore

fun addUser (userId : String) {
    db.collection("users")
        .add(userId)
        .addOnSuccessListener {documentReference ->
          Log.d (TAG,  "DocumentSnapshot added with ID: $(documentReference.id)")
        }
        .addOnFailureListener { e ->
            Log.d(TAG, "Error adding document", e)
        }
}

fun readUser(userId: String){
    db.collection("users.userId")
        .get()
        .addOnSuccessListener { result ->
            for (document in result){
                Log.d(TAG, "${document.id} => ${document.data}")
            }

        }
        .addOnFailureListener { exception ->
            Log.d(TAG, "Error adding document", exception)
        }
}