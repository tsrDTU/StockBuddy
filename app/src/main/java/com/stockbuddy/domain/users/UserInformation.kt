package com.stockbuddy.domain.users

//noinspection SuspiciousImport
import android.R
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.installations.remote.TokenResult


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

//    val docRef = db.collection("users").document(userId)


 //   docRef.get().addOnSuccessListener { OnSuccessListener<TokenResult>(TokenResult) -> Unit }

//  val usr = db.collection("users/tsr/FirstName")
 //       .get().result
        /*
        .addOnSuccessListener { result ->
            for (document in result){
                Log.d(TAG, "${document.id} => ${document.data}")
 //               textView?.text = "${document.id}=> ${document.data}  "
            }

        }
        .addOnFailureListener { exception ->
            Log.d(TAG, "Error adding document", exception)
        }

         */
 //   textView?.text = usr.toString()
 //   val db = FirebaseFirestore.getInstance()
    val docRef = db.collection("users").document("0Il6viDGKOoaZmsSOwxR")
    docRef.get().addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val document = task.result
            if (document.exists()) {
                // Update your TextView with the user's data from Firestore
                val data = document.getString("FirstName")
                if (textView != null) {
                    textView.setText(data)
                }
            } else {
                Log.d(TAG, "No such document")
            }
        } else {
            Log.d(TAG, "get failed with ", task.exception)
        }
    }

}

/* From Co-pilot */
/*
class YourActivity : AppCompatActivity() {
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  //      setContentView(binding.root)
 //       textView = findViewById<TextView>(R.id.textView)
        val db = FirebaseFirestore.getInstance()
   //     val user: FirebaseUser = FirebaseAuth.getInstance().getCurrentUser()
        val user = "tsr"
        if (user != null) {
     //       val userId: String = user.getUid()
            val userId = "tsr"
            val docRef = db.collection("users").document(userId)
            docRef.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document.exists()) {
                        // Update your TextView with the user's data from Firestore
                        val data = document.getString("yourField")
                        textView.setText(data)
                    } else {
                        Log.d(TAG, "No such document")
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.exception)
                }
            }
        }
    }
}

 */