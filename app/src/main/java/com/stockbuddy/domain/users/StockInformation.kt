package com.stockbuddy.domain.users


import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.data.StockData

//private var userIdFirestore = ""


fun addStock (userId: String, stockName: String, numOfStocks : Int, purPrice: Double, purCost: Double, purDate: String) {
  /*  val stock = hashMapOf<StockData>(
        "StockId" to userId,
        "FirstName" to first,
        "LastName" to last,
        "EmailAddress" to email

    )

   */
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


/*
class StockViewModel : ViewModel() {
    private var _actStock = MutableStateFlow<List<StockData>>(emptyList())
    var actStock: StateFlow<List<StockData>> = _actStock

    init {
        ReadStock(userIdFirestore)
    }

    private fun ReadStock(userId: String){

        val db = Firebase.firestore
        var fieldValue : String = ""
        val usr = StockData (
            Emailaddress = "",
            FirstName = "",
            LastName = "",
            StockId = ""
        )


        db.collection("users")
            .whereEqualTo("StockId", userId)
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

@Composable
fun ShowStockInformation(viewModel: StockViewModel) {

    val dataList by viewModel.actUser.collectAsState()

    LazyColumn {
        items(dataList) { dataList ->
            // ListItemComposable
            //             Text(text = dataList.toString())
            Text(text = dataList.FirstName.toString())
            Text(text = dataList.LastName.toString())
        }
    }
}

 */
