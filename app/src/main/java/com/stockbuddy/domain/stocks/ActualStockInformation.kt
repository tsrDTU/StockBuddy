package com.stockbuddy.domain.stocks


import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.data.API.fetchStockData
import com.stockbuddy.data.UserData
import com.stockbuddy.domain.users.userIdFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

var stockToSearch : String = ""
var stockPriceFound : String = ""
fun getActualstockInformation(navController: NavHostController,stock : String ) {

    fetchStockData(stock) { result ->
        //appends to our dataList
        //returns the string: "(name of stock) is worth (price of stock)"
        //incase of error it returns "Error fetching data for (name of stock): (error)

        if (result.isNotEmpty()) {
            stockToSearch = stock
            stockPriceFound = result
            navController.navigate("SaveStockInFirestore")
        }

    }
    /*
    val db = Firebase.firestore

    db.collection("users")
        .whereEqualTo("UserId", userIdFirestore)
        .get()
        .addOnSuccessListener { documents ->
            for (document in documents) {
                // UserId found, navigate to next screen
                navController.navigate("HomePage")
                return@addOnSuccessListener
            }
            navController.navigate("NewUser")
        }
        .addOnFailureListener { e ->
            // Handle failure
        }

     */
}



/*
fun getActualstockInformation(stock: String, Stockdata: DoubleArray) {
    fetchStockData(listOf(stock), "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a") { result ->
        //appends to our dataList
        //returns the string: "(name of stock) is worth (price of stock)"
        //incase of error it returns "Error fetching data for (name of stock): (error)

        Stockdata[0] = result.toDouble()

    }
}

 */

/*
class getActualstockInformation : ViewModel() {
    private var _actStockPrice = MutableStateFlow<String>(0.0)
    var actStockPrice: StateFlow<String> = _actStockPrice

    init {
        ReadUser(stockToSearch)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun ReadStock(actStock: String){
        fetchStockData(listOf(stock), "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a") { result ->
            //appends to our dataList
            //returns the string: "(name of stock) is worth (price of stock)"
            //incase of error it returns "Error fetching data for (name of stock): (error)

           val sPrice : String = result
            _actStockPrice = sPrice


        }

 */


/*
        val db = Firebase.firestore


        val usr: UserData = UserData(
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
        */

