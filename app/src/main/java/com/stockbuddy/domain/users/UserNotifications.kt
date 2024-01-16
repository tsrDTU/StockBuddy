package com.stockbuddy.domain.users

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.UniversalDef.NotificationsBox
import com.stockbuddy.data.NotificationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.StockViewModel


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
fun ShowUserNotifications(viewModel: StockViewModel,navController : NavHostController ) {

//    val dataList by viewModel.actNotification.collectAsState()
    val dataList by viewModel.actStock.collectAsState()


    LazyColumn {

       // TopBar(navController = navController, title = "ShowUserNotifications")

        val sortedList = dataList.sortedBy { it.PurDate } // sorting method info from from ChatGPT

        items(sortedList) {item ->
            val sPrice : Double = item.PurPriceEuro!!.toDouble()
            val  nrStock : Int = item.NumberOfStocks!!.toInt()
            val cost : Double = item.PurCostEuro!!.toDouble()
            val total : Double = sPrice * nrStock + cost;
            NotificationsBox(
                navController,
                "Purchase Confirmed",
                "Date: ${item.PurDate}",
                "You bought ${item.NumberOfStocks} amount of ${item.StockName} stock for ${item.PurPriceEuro} pr stock price: $total Euro"
            )
        }
    }

}