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
import com.stockbuddy.domain.users.StockViewModel



@Composable
fun ShowUserNotifications(viewModel: StockViewModel,navController : NavHostController ) {

//    val dataList by viewModel.actNotification.collectAsState()
    val dataList by viewModel.actStock.collectAsState()


    LazyColumn {

        val sortedList = dataList.sortedBy { it.PurDate } // sorting method info from from ChatGPT

        items(sortedList) {item ->
            val sPrice : Double = item.PurPriceEuro!!.toDouble()
            val  nrStock : Int = item.NumberOfStocks!!.toInt()
            val cost : Double = item.PurCostEuro!!.toDouble()
            var total : Double = sPrice * nrStock + cost;
            val sold : String = item.Sold.toString()

            NotificationsBox(

                navController,
                "Purchase Confirmed",
                "Date: ${item.PurDate}",
                "You bought ${item.NumberOfStocks} amount of ${item.StockName} stock for ${item.PurPriceEuro} pr stock price: $total Euro"
            )

            if (sold.equals("true")) {
                var total : Double = sPrice * nrStock + cost;
                NotificationsBox(

                    navController,
                    "Sold Confirmed",
                    "Date: ${item.PurDate}",
                    "You sold ${item.NumberOfStocks} amount of ${item.StockName} stock for ${item.SellPriceEuro} pr stock price: $total Euro"
                )

            }
        }
    }

}