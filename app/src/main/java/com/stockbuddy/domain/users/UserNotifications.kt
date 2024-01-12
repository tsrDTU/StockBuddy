package com.stockbuddy.domain.users

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.UniversalDef.NotificationsBox
import com.stockbuddy.data.NotificationData
import com.stockbuddy.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


fun userNotification (userId : String, note : String) {

    val user = hashMapOf(
        "UserId" to userId,
        "Note" to note

    )


    val db = Firebase.firestore
    db.collection("notifications")
        .add(user)
        .addOnSuccessListener {documentReference ->
            Log.d ("StateFlow",  "NoteSnapshot added with ID: $(documentReference.id)")
        }
        .addOnFailureListener { e ->
            Log.d("StateFlow", "Error adding note", e)
        }
}

class NotificationViewModel : ViewModel() {
    private var _actNotification = MutableStateFlow<List<NotificationData>>(emptyList())
    var actNotification: StateFlow<List<NotificationData>> = _actNotification

    init {
        ReadNotification(userIdFirestore)
    }

    private fun ReadNotification(userId: String){

        val db = Firebase.firestore



        db.collection("notifications")
            .whereEqualTo("UserId", userId)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {

                        val note: NotificationData = NotificationData(
                            UserId = "",
                            Notification = ""
                        )

                        Log.d("StateFlow", document.id + " => " + document.data)

                        note.UserId = document.getString("UserId").toString()
                        note.Notification = document.getString("Note").toString()



                        val updatedList = _actNotification.value.toMutableList().apply {
                            add(note)
                        }
                        _actNotification.value = updatedList


                    }
                } else {
                    Log.d("StateFlow", "Error getting documents: ", task.exception)
                }
            }

    }
}

@Composable
fun ShowUserNotifications(viewModel: NotificationViewModel) {

    val dataList by viewModel.actNotification.collectAsState()

    LazyColumn {


        items(dataList) { dataList ->
            // ListItemComposable
                         Text(text = dataList.toString())
     //       Text(text = dataList.firstName.toString())
     //      Text(text = dataList.lastName.toString())
        }


    }
}