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
import androidx.navigation.NavHostController
import com.stockbuddy.R
import com.stockbuddy.UniversalDef.NotificationsBox
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

//        Log.d("StateFlow", "StockViewModel $userId: ")

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
            val stName : String = dataList.StockName.toString()
            val stPrice : Double = dataList.PurPriceEuro!!.toDouble()
            val  nrStocks : Int = dataList.NumberOfStocks!!.toInt()
            val sold : String = dataList.Sold!!.toString()
            val totVal = stPrice * nrStocks

            if (sold.equals("false")) {

            Box(
                modifier = Modifier
                    .width(410.dp)
                    .height(170.dp)
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

                    Text(
                        text = "Stock Name: $stName\nAmount Owned: $nrStocks\nPurchase price pr. stock: ${dataList.PurPriceEuro} Euro\nDate for purchase: ${dataList.PurDate}\nPuschase trading cost: ${dataList.PurCostEuro} Euro\n Total Value: $totVal Euro",
                        color = Color.White // Set the text color
                    )
                }


            }

        }
    }

}


@Composable
fun ShowStockHistory(viewModel: StockViewModel,navController : NavHostController) {

//    val dataList by viewModel.actNotification.collectAsState()
    val dataList by viewModel.actStock.collectAsState()


    LazyColumn {

        /*
        val sortedList = dataList.sortedBy { it.PurDate } // sorting method info from from ChatGPT

        var histPrifitPurTotal : Double = 0.0
        var histProfitSellTotal : Double = 0.0
        var histActivePurAmount : Double = 0.0

        items(sortedList) {item ->

            val sold : String = item.Sold.toString()

            val  nrStock : Int = item.NumberOfStocks!!.toInt()

            val pPrice : Double = item.PurPriceEuro!!.toDouble()
            val pcost : Double = item.PurCostEuro!!.toDouble()
            val ptotal : Double = pPrice * nrStock + pcost;
            if (sold.equals("true")) {
                histPrifitPurTotal += ptotal
            }
            else {
                histActivePurAmount += ptotal
            }

            val sPrice : Double = item.SellPriceEuro!!.toDouble()
            val scost : Double = item.SellCostEuro!!.toDouble()

            val stotal : Double = sPrice * nrStock + scost;
            if (sold.equals("true")) {
                histProfitSellTotal += stotal
            }

            NotificationsBox(
                navController,
                "Purchase",
                "Date: ${item.PurDate}",
                "You bought ${item.NumberOfStocks} amount of ${item.StockName} stock for ${item.PurPriceEuro} pr stock price: $ptotal Euro"
            )

            if (sold.equals("true")) {
                val prof : Double = nrStock * (sPrice - pPrice)+ scost + pcost
                val profPct : Double = 100.0 * prof/pPrice
                NotificationsBox(
                    navController,
                    "Purchase",
                    "Date: ${item.SellDate}",
                    "You sold ${item.NumberOfStocks} amount of ${item.StockName} stock for ${item.SellPriceEuro} pr stock price: $stotal Euro, Profit: $prof Euro $profPct pct"
                )
            }
            val totaProfit : Double = histProfitSellTotal - histActivePurAmount
            val totaProfitPct : Double = 100.0 * totaProfit/histActivePurAmount
            NotificationsBox(
                navController,
                "Imvestment result",
                "Date:  ",
                "You total profit $totaProfit Euro $totaProfitPct pct"
            )


        }

 */


    }

}






