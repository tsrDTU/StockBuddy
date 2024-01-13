package com.stockbuddy.domain.users


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.data.StockData
import androidx.lifecycle.ViewModel
import com.stockbuddy.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

//private var userIdFirestore = ""

public var stockNameFirestore = ""

//val inputStream: InputStream = context.resources.openRawResource(R.raw.my_file)

fun purchaseStock (userId: String, stockName: String, numOfStocks : Int, purPrice: Double, purCost: Double, purDate: String) {
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

          userNotification(userIdFirestore,"$numOfStocks $stockName Stocks purchased at a price of $purPrice pr stock. Costs: $purCost. date of the trade: $purDate")
        }
        .addOnFailureListener { e ->
            Log.d(TAG, "Error adding document", e)
        }
}





fun selectStockInFirestore(stockName: String){
    stockNameFirestore = stockName
}


/* ChatGPT has given an example of how it is possible to update a field. Then the code is modified by Torben */
fun sellStock (userId: String, stockName: String,sellPriceEuro: Double, sellCostEuro: Double, sellDate: String) {


    val db = Firebase.firestore
    val collectionRef = db.collection("stockTradingHistory")
    val query = collectionRef.whereEqualTo("UserId", userId).whereEqualTo("StockName", stockName)
    var alreadySold : Boolean = false

    query.get().addOnCompleteListener { task ->
        if (task.isSuccessful) {

            for (document in task.result) {
                if (document.getBoolean("Sold") == true) {
                    alreadySold = true
                }

            }
        }
    }

    if (!alreadySold) {
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
                            userNotification(userId,"All stocks $stockName is sold at price of $sellPriceEuro. Cost: $sellCostEuro. Data of the trade: $sellDate")
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
    else {
        userNotification(userId,"The stock $stockName Stocks cannot be sold since it is already sold")
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


            Box(
                modifier = Modifier
                    .width(329.dp)
                    .height(100.dp)
                    .background(colorResource(id = R.color.regularBox))
                    /*
                    .align(
                        LineHeightStyle
                            .Alignment
                            .Top
                    )

                     */
/*
                    .clickable {
                        navController.navigate("portfolioPage")
                    }

 */


                //                 contentAlignment  LineHeightStyle.Alignment.Center

            ) {
                val stName : String = dataList.StockName.toString()
                val stPrice : Double = dataList.PurPriceEuro!!.toDouble()
                val  nrStocks : Int = dataList.NumberOfStocks!!.toInt()
                val sold : String = dataList.Sold!!.toString()
                val totVal = stPrice * nrStocks
                if (sold.equals("false")) {
                    Text(
                        text = " Name: $stName Number: $nrStocks Total Value: $totVal Euro",
                        color = Color.White // Set the text color
                    )
                }


            }

        }
    }

}



class StockTotalValueViewModel : ViewModel() {
    private var _actStock = MutableStateFlow<List<StockData>>(emptyList())
    var actStock: StateFlow<List<StockData>> = _actStock

    private val _totalStockValue = MutableStateFlow<Double>(0.0)
    val totalStockValue: StateFlow<Double> = _totalStockValue.asStateFlow()

    private val _totalProfit = MutableStateFlow<Double>(0.0)
    val totalProfit: StateFlow<Double> = _totalProfit.asStateFlow()

    private val _totalProfitInPct = MutableStateFlow<Double>(0.0)
    val totalProfitInPct: StateFlow<Double> = _totalProfitInPct.asStateFlow()




    init {
        ReadStock(userIdFirestore)
    }

    private fun ReadStock(userId: String) {

        val db = Firebase.firestore
        var fieldValue : String = ""
        var totalProf : Double = 0.0
        var totalValue : Double = 0.0

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

                            totalValue += nbs!! * purp!! - purc!!
                            Log.d("StateFlow", " Total Value $totalValue")
                        }
                        else
                        {
                            val nbs = usr.NumberOfStocks
                            val purp = usr.PurPriceEuro
                            val purc = usr.PurCostEuro
                            val selp = usr.SellPriceEuro
                            val selc = usr.SellCostEuro

                          //  _totalProfit.value
                            totalProf += nbs!! * (selp!! - purp!!) - (purc!! + selc!!)
                            Log.d("StateFlow", " Total Profit $totalProf")
                        }

                    }

                    _totalStockValue.value += totalValue
                    _totalProfit.value += totalProf
                    _totalProfitInPct.value += 100.0 * totalProf/totalValue

                }
            }
    }
}

private operator fun <T> MutableStateFlow<T>.plusAssign(t: T) {

}


@Composable
fun ShowTotalStockValue(viewModel: StockTotalValueViewModel) {
    val totalStockValue by viewModel.totalStockValue.collectAsState()
    val totalProfit by viewModel.totalProfit.collectAsState()
    val totalProfitInPct by viewModel.totalProfitInPct.collectAsState()

    Column {
        Text(text = "Total Value of Stocks: $totalStockValue Euro")
        Text(text = String.format("Total profit: $totalProfit Euro, %.2f pct.", totalProfitInPct))
    }
}





