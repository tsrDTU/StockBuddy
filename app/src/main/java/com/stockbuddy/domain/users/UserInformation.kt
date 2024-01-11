package com.stockbuddy.domain.users

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.data.StockData
import com.stockbuddy.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

var userIdFirestore = ""


fun addUser (userId : String, first : String, last : String, email : String) {

   val user = hashMapOf(
        "UserId" to userId,
        "FirstName" to first,
        "LastName" to last,
       "Emailaddress" to email
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

fun selectUserInFirestore(userId: String){
    userIdFirestore = userId
}


/*
With assistance from chatGPT
 */
class UserViewModel : ViewModel() {
    private var _actUser = MutableStateFlow<List<UserData>>(emptyList())
    var actUser: StateFlow<List<UserData>> = _actUser

    init {
        ReadUser(userIdFirestore)
    }

  private fun ReadUser(userId: String){

      val db = Firebase.firestore


      val usr:UserData = UserData(
          emailaddress = "",
          firstName = "",
          lastName = "",
          userId = ""
      )


        db.collection("users")
            .whereEqualTo("UserId", userId)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d("StateFlow", document.id + " => " + document.data)

                        usr.userId = document.getString("UserId").toString()
                        usr.firstName = document.getString("FirstName").toString()
                        usr.lastName = document.getString("LastName").toString()
                        usr.emailaddress = document.getString("Emailaddress").toString()


                        val updatedList = _actUser.value.toMutableList().apply {
                            add(usr)
                        }
                        _actUser.value = updatedList


                    }
                } else {
                    Log.d("StateFlow", "Error getting documents: ", task.exception)
                }
            }

    }
}

@Composable
fun ShowUserInformation(viewModel: UserViewModel) {

    val dataList by viewModel.actUser.collectAsState()

    LazyColumn {
        items(dataList) { dataList ->
            // ListItemComposable
            //             Text(text = dataList.toString())
            Text(text = dataList.firstName.toString())
            Text(text = dataList.lastName.toString())
        }
    }
}
