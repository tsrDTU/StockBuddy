package com.stockbuddy.domain.users


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.data.StockData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

//private var userIdFirestore = ""


fun addStock (userId: String, stockName: String, numOfStocks : Int, purPrice: Double, purCost: Double, purDate: String) {
   val stock = hashMapOf(
        "UserId" to userId,
        "StockName" to stockName,
        "NumberOfStocks" to numOfStocks,
        "PurPriceEuro" to purPrice,
        "PurCostEuro" to purCost,
         "PurDate"  to purDate,
        "Sold" to false,
       "SellPriceEuro" to 0.0,
       "SellCostEuro" to 0.0,
       "SellDate" to ""
    )

   /*
    val stock = StockData (
        UserId = userId,
        StockName = stockName,
        NumberOfStocks = numOfStocks,
     PurPriceEuro = purPrice,
     PurCostEuro = purCost,
     PurDate = purDate,
     Sold = false,
     SellPriceEuro = 0.0,
     SellCostEuro = 0.0,
     SellDate = ""
    )

   */
    val db = Firebase.firestore
    db.collection("stockTradingHistory")
        .add(stock)
        .addOnSuccessListener {documentReference ->
            Log.d (TAG,  "DocumentSnapshot added with ID: $(documentReference.id)")
        }
        .addOnFailureListener { e ->
            Log.d(TAG, "Error adding document", e)
        }
}
/*
fun selectUserInFirestore(userId: String){
    userIdFirestore = userId
}

 */



class StockViewModel : ViewModel() {
    private var _actStock = MutableStateFlow<List<StockData>>(emptyList())
    var actStock: StateFlow<List<StockData>> = _actStock

    init {
        ReadStock(userIdFirestore)
    }

    private fun ReadStock(userId: String) {

        val db = Firebase.firestore
        var fieldValue : String = ""
        val usr = StockData (
            UserId = userId,
            StockName = "",
            NumberOfStocks = 0,
            PurPriceEuro = 0.0,
            PurCostEuro = 0.0,
            PurDate = "",
            Sold = false,
            SellPriceEuro = 0.0,
            SellCostEuro = 0.0,
            SellDate = ""
        )


        db.collection("stockTradingHistory")
            .whereEqualTo("UserId", userId)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d(TAG, document.id + " => " + document.data)

                        usr.UserId = document.getString("UserId").toString()
                        usr.StockName = document.getString("StockName").toString()
                          usr.NumberOfStocks = document.getLong("NumberOfStocks")?.toInt()
                        usr.PurPriceEuro = document.getDouble("PurPriceEuro")
                        usr.PurCostEuro = document.getDouble("PurCostEuro")
                        usr.PurDate = document.getString("PurDate").toString()
                        usr.Sold = document.getBoolean("Sold")
                        usr.SellPriceEuro = document.getDouble("SellPriceEuro")
                        usr.SellCostEuro = document.getDouble("SellCostEuro")
                        usr.SellDate = document.getString("SellDate").toString()


                        val updatedList = _actStock.value.toMutableList().apply {
                            add(usr)
                        }
                        _actStock.value = updatedList

                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.exception)
                }
            }

    }


}




@Composable
fun ShowStockInformation(viewModel: StockViewModel) {

    val dataList by viewModel.actStock.collectAsState()


    LazyColumn {
        items(dataList) { dataList ->
            // ListItemComposable
            //             Text(text = dataList.toString())
            Text(text = dataList.StockName.toString())


        }
    }
}


