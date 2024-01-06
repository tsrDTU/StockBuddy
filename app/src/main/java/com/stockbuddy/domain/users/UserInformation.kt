package com.stockbuddy.domain.users

//noinspection SuspiciousImport

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.TextView
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.stockbuddy.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.lang.Thread.sleep
import kotlinx.coroutines.*
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private var FirstName : String = " XY "
private var LarstName : String = " AB "

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


 fun ReadUser(userId: String){

    val db = Firebase.firestore
    var fieldValue : String = ""


   db.collection("users")
        .whereEqualTo("UserId", userId)
        .get()
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                for (document in task.result) {
                    Log.d(TAG, document.id + " => " + document.data)
                    // You can now work with the document
                    // For example, to get a field's value:
                     fieldValue = document.getString("FirstName").toString()
                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.exception)
            }
        }

}



fun  ReadUserOnly(userId: String, actUser: List<UserData>): String= runBlocking{
    val db = Firebase.firestore

    val textView: TextView? = null

    val job = launch {
        db.collection("users")
            .whereEqualTo("UserId", userId)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d(TAG, document.id + " => " + document.data)
                        // You can now work with the document
                        // For example, to get a field's value:
                        FirstName = document.getString("FirstName").toString()
                        actUser

                        textView?.setText(FirstName)




                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            }
    }

    job.join() // wait until child coroutine completes

    return@runBlocking FirstName
}

fun getFirstName(): String {

    return FirstName
}


fun getLastName(): String {

    return LarstName
}

fun getNytTal(n : Int) : Int {

    return n + 1
}

/*
With assistance from chatGPT
 */
class MyViewModel : ViewModel() {
    private var _actUser = MutableStateFlow<List<UserData>>(emptyList())
    var actUser: StateFlow<List<UserData>> = _actUser

    init {
        ReadUser("tsr")
    }

  private fun ReadUser(userId: String){

        val db = Firebase.firestore
        var fieldValue : String = ""
      val usr = UserData (
          Emailaddress = "",
          FirstName = "",
          LastName = "",
          UserId = ""
      )


        db.collection("users")
            .whereEqualTo("UserId", userId)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d(TAG, document.id + " => " + document.data)
                        // You can now work with the document
                        // For example, to get a field's value:
                    //    fieldValue = document.getString("FirstName").toString()
                        usr.UserId = document.getString("UserId").toString()
                        usr.FirstName = document.getString("FirstName").toString()
                        usr.LastName = document.getString("LastName").toString()
                        usr.Emailaddress = document.getString("Emailaddress").toString()


                        val updatedList = _actUser.value.toMutableList().apply {
                            add(usr)
                        }
                        _actUser.value = updatedList


                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            }

    }
}


