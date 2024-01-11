package com.stockbuddy.domain.users


import android.content.ContentValues.TAG
import android.os.Environment
import android.util.Log
import androidx.compose.foundation.layout.Column
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
import androidx.lifecycle.viewModelScope
import com.stockbuddy.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.InputStream
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

//private var userIdFirestore = ""

public var stockNameFirestore = ""

//val inputStream: InputStream = context.resources.openRawResource(R.raw.my_file)

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





fun selectStockInFirestore(stockName: String){
    stockNameFirestore = stockName
}


/* created by ChatGPT modified by Torben */
fun sellStock (userId: String, stockName: String,sellPriceEuro: Double, sellCostEuro: Double, sellDate: String) {


    val db = Firebase.firestore
    val collectionRef = db.collection("stockTradingHistory")
    val query = collectionRef.whereEqualTo("UserId", userId).whereEqualTo("StockName", stockName)

    query.get()
        .addOnSuccessListener { documents ->
            for (document in documents) {
                val docRef = collectionRef.document(document.id)
                val updatedData = hashMapOf(
                    "Sold" to true,
                    "SellPriceEuro" to sellPriceEuro,
                    "SellCostEuro" to sellCostEuro,
                    "SellDate" to sellDate
                )
                docRef.update(updatedData as Map<String, Any>)
                    .addOnSuccessListener {
                        Log.d("StateFlow", "Document updated successfully!")
                    }
                    .addOnFailureListener { e ->
                        Log.w("StateFlow", "Error in updating document", e)
                    }
            }
        }
        .addOnFailureListener { exception ->
            Log.w("StateFlow", "Error in searching for document", exception)
        }
}




class StockViewModel : ViewModel() {
    private var _actStock = MutableStateFlow<List<StockData>>(emptyList())
    var actStock: StateFlow<List<StockData>> = _actStock

    init {
        ReadStock(userIdFirestore)
    }

    private fun ReadStock(userId: String) {

        val db = Firebase.firestore
        var fieldValue : String = ""

        db.collection("stockTradingHistory")
            .whereEqualTo("UserId", userId)
 //           .whereEqualTo("StockName", stockNameFirestore)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d("StateFlow", document.id + " => " + document.data)

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
 //                           Log.d("StateFlow", "List after adding: $this")
                        }
                        _actStock.value = updatedList
 //                       Log.d("StateFlow", "Final _actStock value: ${_actStock.value}")

                    }
                } else {
                    Log.d("StateFlow", "Error getting documents: ", task.exception)
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
                         Text(text = dataList.toString())
      //      Text(text = dataList.StockName.toString())


        }
    }
}



class StockTotalVavueViewModel : ViewModel() {
    private var _actStock = MutableStateFlow<List<StockData>>(emptyList())
    var actStock: StateFlow<List<StockData>> = _actStock

    private val _totalStockValue = MutableStateFlow<Double>(0.0)
    val totalStockValue: StateFlow<Double> = _totalStockValue.asStateFlow()

    private val _totalProfit = MutableStateFlow<Double>(0.0)
    val totalProfit: StateFlow<Double> = _totalProfit.asStateFlow()



    init {
        ReadStock(userIdFirestore)
    }

    private fun ReadStock(userId: String) {

        val db = Firebase.firestore
        var fieldValue : String = ""

        db.collection("stockTradingHistory")
            .whereEqualTo("UserId", userId)
            //           .whereEqualTo("StockName", stockNameFirestore)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d("StateFlow", document.id + " => " + document.data)

                        val usr = StockData(
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


                        val sld = usr.Sold
                        if (sld == false) {
                            val nbs = usr.NumberOfStocks
                            val purp = usr.PurPriceEuro
                            val purc = usr.PurCostEuro

                            _totalStockValue.value +=
                                nbs!! * purp!! - purc!!
                        }
                        else
                        {
                            val nbs = usr.NumberOfStocks
                            val purp = usr.PurPriceEuro
                            val purc = usr.PurCostEuro
                            val selp = usr.SellPriceEuro
                            val selc = usr.SellCostEuro

                            _totalProfit.value += nbs!! * (selp!! - purp!!) - (purc!! + selc!!)
                                Log.d("StateFlow", "$_totalProfit")
                        }

                    }
                }
            }
    }
}

private operator fun <T> MutableStateFlow<T>.plusAssign(t: T) {

}


@Composable
fun ShowTotalStockValue(viewModel: StockTotalVavueViewModel) {
    val totalStockValue by viewModel.totalStockValue.collectAsState()
    val totalProfit by viewModel.totalProfit.collectAsState()

    Column {
        Text(text = "Total Value of Stocks: $totalStockValue Euro")
        Text(text = "Total profit: $totalProfit Euro")
    }
}





