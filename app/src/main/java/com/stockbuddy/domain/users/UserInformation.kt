package com.stockbuddy.domain.users

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore





fun addUser (userId : String, first : String, last : String, email : String) {
    val user = hashMapOf<String, String>(
       "UserId" to userId,
        "FirstName" to first,
        "LastName" to last,
        "EmailAddress" to email

    )
    val db = Firebase.firestore
    db.collection("users")
        .add(user)
        .addOnSuccessListener {documentReference ->
          Log.d (TAG,  "DocumentSnapshot added with ID: $(documentReference.id)")
        }
        .addOnFailureListener { e ->
            Log.d(TAG, "Error adding document", e)
        }
}

fun readUser(userId: String){
    val textView: TextView? = null
    val db = Firebase.firestore
  val usr = db.collection("users.userId")
        .get()
        .addOnSuccessListener { result ->
            for (document in result){
                Log.d(TAG, "${document.id} => ${document.data}")
 //               textView?.text = "${document.id}=> ${document.data}  "
            }

        }
        .addOnFailureListener { exception ->
            Log.d(TAG, "Error adding document", exception)
        }
    textView?.text = usr.toString()

}